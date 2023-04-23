package com.osmium.schoolconnect.backend.entity;

import lombok.Data;

/**
 * @Author
 * @Date 2023/4/18
 * @Description
 */
@Data
public class WeixinTokenResult
{
    private String access_token;
    private Integer expires_in;
}
