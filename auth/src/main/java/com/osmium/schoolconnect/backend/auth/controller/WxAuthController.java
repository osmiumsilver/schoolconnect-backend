package com.osmium.schoolconnect.backend.auth.controller;


import cn.hutool.json.JSONObject;
import com.osmium.schoolconnect.backend.auth.entity.WxLogin;
import com.osmium.schoolconnect.backend.auth.utils.WeChatBackendUtils;
import com.osmium.schoolconnect.backend.misc.Result;
import org.springframework.web.bind.annotation.*;


/**
 * @Author
 * @Date 2022/11/1
 * @Description
 */
@RestController
//@Slf4j
//@Validated
@RequestMapping("/auth")
public class WxAuthController {

    @PostMapping("/wxlogin")
    public Result<JSONObject> getWxLogin(@RequestBody JSONObject wxLogin) {
        JSONObject getOpenIDSessionkey= WeChatBackendUtils.getSessionKeyOrOpenId(wxLogin.get("code",String.class));
        String openId = getOpenIDSessionkey.get("openid",String.class);
        String sessionKey = getOpenIDSessionkey.get("session_key",String.class);
        return Result.success(getOpenIDSessionkey);
    }
}

