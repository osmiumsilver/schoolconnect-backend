package com.osmium.schoolconnect.backend.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.osmium.schoolconnect.backend.entity.NotificationData;
import com.osmium.schoolconnect.backend.entity.WechatResult;
import com.osmium.schoolconnect.backend.misc.RequestException;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @Author Abel www.osmium.com
 * @Date 2023/2/4
 * @Description 微信后台Utils
 */

@Component
@Slf4j
public class WeChatBackendUtils {

    /**
     * @Author osmium Abel YAO
     * @Description Here ARE SOME EXTRA CODE BECAUSE SPRING DOESN'T ALLOW STATIC FIELD INJECTION AND I HAD NO CHOICE !!
     * 静态字段注入 我必须得这么做
     */

    private static String appId;
    private static String appSecret;

    @Autowired
    public void setMyShit(@Value("${wechat-mini-program.appid}") String appId, @Value("${wechat-mini-program.secret}") String appSecret) {
        WeChatBackendUtils.appId = appId;
        WeChatBackendUtils.appSecret = appSecret;
    }

    public static JSONObject test() {
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("template_id", "666");
        return JSONUtil.parseObj(HttpUtil.post(requestUrl, paramMap));

    }

    public static JSONObject getSessionKeyOrOpenId(String code) {

        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        LinkedHashMap<String, Object> requestUrlParam = new LinkedHashMap<>();
        //小程序appId
        requestUrlParam.put("appid", appId);
        //小程序secret
        requestUrlParam.put("secret", appSecret);
        //小程序端返回的code
        requestUrlParam.put("js_code", code);
        //默认参数
        requestUrlParam.put("grant_type", "authorization_code");
        //发送post请求读取调用微信接口获取openid用户唯一标识
        return JSONUtil.parseObj(HttpUtil.get(requestUrl, requestUrlParam));

    }

    public static JSONObject getUserInfo(String encryptedData, String sessionKey, String iv) {
        // 被加密的数据
        byte[] dataByte = Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decode(sessionKey);
        // 偏移量
        byte[] ivByte = Base64.decode(iv);
        try {
            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            //Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            // 初始化
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return JSONUtil.parseObj(result);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static WechatResult sendNotification(String accessToken, String templateId, String toUser, NotificationData data, String miniprogramState) {
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=" + accessToken;
        JSONObject obj =new JSONObject();
       obj.put("template_id", templateId);
        obj.put("touser", toUser);
        obj.put("data", JSONUtil.parse(data));
        obj.put("miniprogram_state", miniprogramState);
        obj.put("lang", "zh_CN");
        log.warn(String.valueOf(obj));
        WechatResult status = JSONUtil.toBean(HttpRequest.post(requestUrl).body(String.valueOf(obj)).execute().body(), WechatResult.class);
        //发送post请求读取调用微信接口获取openid用户唯一标识
        return status;
    }

    public static JSONObject getAccessToken() {
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/token";
        LinkedHashMap<String, Object> requestUrlParam = new LinkedHashMap<>();
        //小程序appId
        requestUrlParam.put("appid", appId);
        //小程序secret
        requestUrlParam.put("secret", appSecret);
        //默认参数
        requestUrlParam.put("grant_type", "client_credential");
        //发送post请求读取调用微信接口获取openid用户唯一标识
        return JSONUtil.parseObj(HttpUtil.get(requestUrl, requestUrlParam));
    }
}
