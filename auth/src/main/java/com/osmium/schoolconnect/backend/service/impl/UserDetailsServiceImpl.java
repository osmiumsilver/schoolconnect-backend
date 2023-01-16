package com.osmium.schoolconnect.backend.service.impl;

import com.osmium.schoolconnect.backend.entity.Login;
import com.osmium.schoolconnect.backend.service.ILoginService;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author
 * @Date 2023/1/13
 * @Description
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private ILoginService loginService;

    @Override
    public UserDetails loadUserByUsername(String username)  {
        Login loginUser = loginService.getById(username);
        if (username == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        return loginUser;
    }
}
