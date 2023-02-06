package com.osmium.schoolconnect.backend.auth.config;

import com.osmium.schoolconnect.backend.auth.service.ILoginService;
import com.osmium.schoolconnect.backend.misc.Result;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Author Abel www.osmium.com
 * @Date 2023/1/13
 * @Description 定制化授权供应者 Auth Provider
 */

@Component
@Slf4j
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private ILoginService iLoginService;
    @Resource //从Security把SHA256 加密器装配过来
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) {
        final String username = (authentication.getPrincipal() == null) ? "未提供账号" : authentication.getName();
        if (StringUtils.isEmpty(username)) {
            throw new BadCredentialsException("invaild login details");
        }
        UserDetails user;

            user = iLoginService.loadUserByUsername(username);

        return createSuccessfulAuthentication(authentication, user);
        //return tryAuthWithDatabase(username, password);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals( //复写Provider为UsernamePasswordAuthentication
                UsernamePasswordAuthenticationToken.class);
    }

    private Authentication createSuccessfulAuthentication(final Authentication authentication, final UserDetails user) { //user是数据库哪来的 authen是我登录时候用的
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), authentication.getCredentials(), user.getAuthorities());
        log.trace("数据库中的密码： (Password in my database )"+user.getPassword()+" "+"我穿进去的明文 : "+authentication.getCredentials() + " password encoded : "+passwordEncoder.encode(authentication.getCredentials().toString()));


        if (passwordEncoder.matches(authentication.getCredentials().toString(), user.getPassword())){ //生密码在前，数据库密在后
            token.setDetails(authentication.getDetails()); //面子授权被放到Token授权中
            return token;
        } else {
            Result.error(ResultCode.AUTH_PWD_ERR);
            throw new BadCredentialsException("密码不正确");

        }
    }
    //放在下面看看 这是不太对的代码
    //private Authentication tryAuthWithDatabase(final String username,final String password){
    // UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken();
    //    return UsernamePasswordAuthenticationToken.unauthenticated(username, password);
    //
    //} else {
    //        Collection<? extends GrantedAuthority> authorities = result.getAuthorities();
    //        return UsernamePasswordAuthenticationToken.authenticated(username, password, authorities);
    //}
}



