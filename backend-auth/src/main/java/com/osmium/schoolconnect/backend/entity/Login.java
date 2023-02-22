package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.osmium.schoolconnect.backend.misc.AuthorityCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;


/**
 * @Author abel
 * @Date 2022/11/2
 * @Description 登录记录类
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("t_login as login JOIN t_user as user on login.username = user.user_id")
public class Login implements Serializable, UserDetails {
    @Serial
    private static final long serialVersionUID = 1L;
    @TableId("login.username")
    @Schema(description = "用户名")
    private String username;
    @TableField("login.password")
    @Schema(description = "密码")
    private String password;
    @TableField("user.role")
    @Schema(description = "权限")
    private int authority;
    @TableField("user.status")
    @Schema(description = "账户是否锁定")
    private int isEnabled;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(AuthorityCode.get(getAuthority()));
    }

    @Override
    public boolean isAccountNonExpired() { //这三个我用不上啊
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
    public boolean isEnabled() { //是否仍然可用
        Boolean enabled = null;
        switch (getIsEnabled()) {
            case 0, 1 -> enabled = true;
            case 2 -> enabled = false;
        }
        return Boolean.TRUE.equals(enabled);

    }

}
