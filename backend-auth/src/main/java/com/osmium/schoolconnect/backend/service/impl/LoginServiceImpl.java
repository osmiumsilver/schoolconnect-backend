package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.Login;
import com.osmium.schoolconnect.backend.mapper.LoginMapper;
import com.osmium.schoolconnect.backend.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * @Author
 * @Date 2022/12/7
 * @Description
 */
@Service
@Validated
@Slf4j
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements ILoginService, UserDetailsService {
    //我写的非常方便，我直接把AuthenticationProvider 重写了 写了自己的鉴权方法，然后把UserDetail的一套直接与Mybatis的Service实现相结合

    @Override //实现Security的load用户名功能
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login loginUser = baseMapper.getUserById(username);
        if (loginUser == null) {
            throw new UsernameNotFoundException("Username not found");
        } else {
            List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(loginUser.getAuthorities().toString());
            return new User(loginUser.getUsername(), loginUser.getPassword(), loginUser.isEnabled(), loginUser.isAccountNonExpired(), loginUser.isCredentialsNonExpired(), loginUser.isAccountNonLocked(), authorities);
        }
    }
}

