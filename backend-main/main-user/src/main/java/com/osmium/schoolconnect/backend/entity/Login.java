package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author
 * @Date 2023/4/5
 * @Description
 */
@Data
@TableName("t_login")
public class Login {
    @TableId
    private String username;

    private String password;
}
