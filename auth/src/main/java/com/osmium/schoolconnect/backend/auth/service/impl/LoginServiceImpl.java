package com.osmium.schoolconnect.backend.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.auth.entity.Login;
import com.osmium.schoolconnect.backend.auth.entity.UsernamePassword;
import com.osmium.schoolconnect.backend.auth.mapper.LoginMapper;
import com.osmium.schoolconnect.backend.auth.service.ILoginService;
import com.osmium.schoolconnect.backend.misc.Result;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author
 * @Date 2022/12/7
 * @Description
 */
@Service
@Slf4j
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements ILoginService, UserDetailsService {

//@Autowired
//    QueryWrapper<Login> wrapper;
@Autowired
    private LoginMapper loginMapper;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //LambdaQueryWrapper<Login> wrapper = new LambdaQueryWrapper<>();
        //wrapper.eq(Login::getUsername, username);
        //Login loginUser = loginMapper.selectOne(wrapper.eq("username",username));
        Login loginUser;
        try {
            loginUser = this.loginMapper.getUserById(username);
        } catch (NullPointerException | IllegalArgumentException exceptions) {
            Result.error(ResultCode.AUTH_NO_SUCH_USER);
            throw new UsernameNotFoundException("用户不存在");
        }
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(loginUser.getAuthorities().toString());
        log.info("loginUser from loadByUsername (From Database) : Username : "+loginUser.getUsername() +" Password" + loginUser.getPassword(), authorities );
        return new User(loginUser.getUsername(), loginUser.getPassword(), authorities);
    }

    @Override
    public UsernamePassword login(String username, String password) {
       return loginMapper.login(username,password);
    }

    @Override
    public Login getUserById(String username) {
        return loginMapper.getUserById(username);
    }


}
