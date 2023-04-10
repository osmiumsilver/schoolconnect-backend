package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.Login;
import com.osmium.schoolconnect.backend.mapper.LoginMapper;
import com.osmium.schoolconnect.backend.misc.AuthException;
import com.osmium.schoolconnect.backend.misc.RequestException;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import com.osmium.schoolconnect.backend.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;

/**
 * @Author
 * @Date 2022/12/7
 * @Description
 */
@Service
@Slf4j
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements ILoginService, UserDetailsService {

//@Autowired 不需要这个 直接调用baseMapper即可
//    QueryWrapper<Login> wrapper;

    @Override //实现Security的load用户名功能
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login loginUser = baseMapper.getUserById(username);
        if (loginUser == null)
        {throw new AuthException(ResultCode.AUTH_NO_SUCH_USER);}
        else{
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(loginUser.getAuthorities().toString());
        return new User(loginUser.getUsername(), loginUser.getPassword(), authorities);}
    }
}

