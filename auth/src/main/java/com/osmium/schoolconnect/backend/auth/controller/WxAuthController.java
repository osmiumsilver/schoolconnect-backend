package com.osmium.schoolconnect.backend.auth.controller;


import cn.hutool.json.JSONObject;
import com.osmium.schoolconnect.backend.auth.entity.OpenID;
import com.osmium.schoolconnect.backend.auth.service.IOpenIDService;
import com.osmium.schoolconnect.backend.auth.utils.WeChatBackendUtils;
import com.osmium.schoolconnect.backend.misc.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


/**
 * @Author
 * @Date 2022/11/1
 * @Description
 */
@RestController
@Slf4j
//@Validated
@RequestMapping("/auth")
public class WxAuthController {
private IOpenIDService iOpenIDService;

    public WxAuthController(IOpenIDService iOpenIDService) {
        this.iOpenIDService = iOpenIDService;
    }

    @PostMapping("/wxlogin")
    public Result<JSONObject> getWxLogin(@RequestBody JSONObject wxLogin) {
        JSONObject getOpenIDSessionkey= WeChatBackendUtils.getSessionKeyOrOpenId(wxLogin.get("code",String.class));
        String openId = getOpenIDSessionkey.get("openid",String.class);
        log.info("OPENID : " + openId);
        saveOpenID(openId);
        return Result.success(getOpenIDSessionkey);
    }


    public void saveOpenID(String openId)
    {
        if(iOpenIDService.getById(openId)==null) {
            log.info(String.valueOf(iOpenIDService.save(new OpenID(openId, null))));
        }
    }
}

