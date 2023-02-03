package com.osmium.schoolconnect.backend.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


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

    @Value("${wechat-miniprogram.appid}")
    private String appId;

    @Value("${wechat-miniprogram.appsecret}")
    private String appSecret;

    @GetMapping("/wxcode")
//    public String authenticateLogin(Authentication authentication)
//{
//    return "Hello ! " + authentication.getName();
//}
    public @ResponseBody String getOpenID(@RequestParam String code) {
        RestTemplate restTemplate = new RestTemplate();
        String reqUrl = String.format("https://api.weixin.qq.com/sns/jscode2session?"+"appid="+appId+"&"+"secret="+appSecret+"&"+"js_code="+code+"&grant_type=authorization_code");
        String response = restTemplate.getForObject(reqUrl, String.class);
        System.out.println(reqUrl);
        System.out.println(appId+appSecret+code);
        System.out.println(response);
        return response;
    }
}

