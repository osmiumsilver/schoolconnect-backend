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
@TableName("v_login")
public class Login implements Serializable, UserDetails {
    @Serial
    private static final long serialVersionUID = 1L;
    @TableId("username")
    @Schema(description = "用户名")
    private String username;
    @TableField("password")
    @Schema(description = "密码")
    private String password;
    @TableField("role")
    @Schema(description = "权限")
    private Integer role;
    @TableField("status")
    @Schema(description = "账户是否锁定")
    private Integer status;

//这里实现地不够好因为我一开始没有完全掌握Security中role和authority的区别 我把AUTHORITY当成role来用了 不过没关系 在这个场景不妨碍
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(AuthorityCode.get(getRole()));
    }

    @Override
    public boolean isAccountNonExpired() { //这三个我用不上啊
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        boolean enabled = false;
        switch (getStatus()) {
            case 0, 1 -> enabled = true;
        }
        return enabled;

    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() { //是否仍然可用
       return true;
    }

}
