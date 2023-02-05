package com.osmium.schoolconnect.backend.auth.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;


/**
 * @Author abel
 * @Date 2022/11/2
 * @Description 登录记录类
 */

@Data
@TableName("t_login")
public class Login implements Serializable, UserDetails {
    @Serial
    private static final long serialVersionUID = 1L;
    @TableId("username")
    @Schema(description = "用户名")
    private String username;
    @Schema(description = "密码")
    private String password;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
