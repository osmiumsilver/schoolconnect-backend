package com.osmium.schoolconnect.backend.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.auth.entity.Login;
import com.osmium.schoolconnect.backend.auth.mapper.LoginMapper;
import com.osmium.schoolconnect.backend.auth.service.ILoginService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author
 * @Date 2022/12/7
 * @Description
 */
@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements ILoginService, UserDetailsService {

    private QueryWrapper<Login> wrapper;
    private LoginMapper loginMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login loginUser = loginMapper.selectOne(wrapper.eq("username",username));
        if (loginUser == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("admin");
        return new User(loginUser.getUsername(),new BCryptPasswordEncoder().encode(loginUser.getPassword()),authorities);
    }

    @Override
    public Login login(String username, String password) {
       return loginMapper.login(username,password);
    }
}
