package com.osmium.schoolconnect.backend.auth.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


/**
 * @Author abel
 * @Date 2022/11/2
 * @Description 登录记录类
 */

@Data
@TableName("t_login")
public class Login{
    private String username;
    private String password;
    @TableId("user_id")
    private String userId;


}
