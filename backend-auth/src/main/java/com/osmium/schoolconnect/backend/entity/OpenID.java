package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author
 * @Date 2023/1/12
 * @Description
 */
@Data
@AllArgsConstructor
@TableName("t_openid")
public class OpenID implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @TableId("openid")
    private String openId;
    private String userId;


}
