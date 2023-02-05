package com.osmium.schoolconnect.backend.auth.entity;

import lombok.Data;

/**
 * @Author
 * @Date 2023/2/4
 * @Description
 */
@Data
public class WxLogin {
    /**
     * 微信小程序生成的code
     */
    private String wxCode;

    /**
     * 非敏感的用户信息
     */
    private String sessionKey;

}
