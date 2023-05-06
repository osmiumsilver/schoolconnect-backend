package com.osmium.schoolconnect.backend.controller;

import cn.hutool.json.JSONObject;
import com.osmium.schoolconnect.backend.utils.WeChatBackendUtils;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author
 * @Date 2023/4/18
 * @Description
 */
@RestController
@RequestMapping("/wechat")
public class WeChatController {
@Operation(summary = "获取微信另一个Token")
@GetMapping("/token")
    public JSONObject getWechatAccessToken(){
return WeChatBackendUtils.getAccessToken();
}

}
