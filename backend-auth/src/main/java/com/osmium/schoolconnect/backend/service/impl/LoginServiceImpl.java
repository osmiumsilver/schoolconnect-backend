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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<Login>  loginUser = Optional.ofNullable(baseMapper.getUserById(username));
        Optional<List<GrantedAuthority>> authorities = Optional.of(AuthorityUtils.commaSeparatedStringToAuthorityList(loginUser.get().getAuthorities().toString()));
        return new User(loginUser.get().getUsername(), loginUser.get().getPassword(),authorities.get());
    }

}
