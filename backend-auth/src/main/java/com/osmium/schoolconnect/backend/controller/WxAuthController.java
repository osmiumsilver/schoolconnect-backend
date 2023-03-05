package com.osmium.schoolconnect.backend.controller;


import cn.hutool.json.JSONObject;
import com.osmium.schoolconnect.backend.entity.OpenID;
import com.osmium.schoolconnect.backend.misc.Result;
import com.osmium.schoolconnect.backend.service.IOpenIDService;
import com.osmium.schoolconnect.backend.utils.RedisUtils;
import com.osmium.schoolconnect.backend.utils.WeChatBackendUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author
 * @Date 2022/11/1
 * @Description
 */
@RestController
@Slf4j
//@Validated
@RequestMapping("/auth")
@Cacheable(value = "openid")
public class WxAuthController {

    private final IOpenIDService iOpenIDService;

    private final RedisUtils redisUtils;

    public WxAuthController(IOpenIDService iOpenIDService, RedisUtils redisUtils) {
        this.iOpenIDService = iOpenIDService;
        this.redisUtils = redisUtils;
    }


    /**
     * 微信登录 传入一次性wxcode，存入并返回openid
     *
     * @param wxLogin
     * @param
     * @return 通用返回Result
     */

    @PostMapping("/wxlogin")
    public Result<JSONObject> getWxLogin(@RequestBody JSONObject wxLogin) { //wxLogin接受code
        JSONObject wxLoginResponse = WeChatBackendUtils.getSessionKeyOrOpenId(wxLogin.get("code", String.class));
        String openId = wxLoginResponse.get("openid", String.class);
        if (iOpenIDService.getById(openId) == null) {
            saveOpenID(openId);
        }
        //if (redisUtils.getCacheObject(openId)!=null) {
        wxLoginResponse.set("user_id", iOpenIDService.getById(openId).getUserId());
        //}
        return Result.success(wxLoginResponse);

    }

    @PostMapping("/wxlogout")
    public Result<JSONObject> logoutWxLogin(@RequestBody String openId) {

        //if (redisUtils.deleteObject(openId)) {
        //    return Result.success();
        //} else return Result.error(ResultCode.AUTH_LOGOUT_ERR);
        //TODO DELETE FROM DB
        return null;
    }

    //    @PostMapping("/wxlogout")
//public Result<JSONObject> wxLogout(@RequestBody String wxLogout)
//    {
//
//        return Result.success(basicInfoMapper.updateById(wxLogout));
//    }
    public void saveOpenID(String openId) {
        log.info(String.valueOf(iOpenIDService.save(new OpenID(openId, null))));
    }
}

