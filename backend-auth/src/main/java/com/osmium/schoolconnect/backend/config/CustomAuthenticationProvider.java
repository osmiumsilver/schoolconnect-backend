package com.osmium.schoolconnect.backend.config;

import com.osmium.schoolconnect.backend.service.ILoginService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
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
    private final ILoginService iLoginService;
    public CustomAuthenticationProvider(ILoginService iLoginService) {
        this.iLoginService = iLoginService;
    }

    @Resource //把SHA256加密器从容器内给拿过来
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) {
        final String username = (authentication.getPrincipal() == null) ? "未提供账号" : authentication.getName();
        if (StringUtils.isEmpty(username)) {
            authentication.setAuthenticated(false);
            throw new BadCredentialsException("未提供账号");
        }
        else return createAuthorization(authentication, iLoginService.loadUserByUsername(username));
    }


    private Authentication createAuthorization(final Authentication authentication, final UserDetails user) { //user是数据库来的 authentication是我登录时候给出的
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), authentication.getCredentials(), user.getAuthorities());
        log.trace("数据库中的密码： (Password in my database )" + user.getPassword() + " " + "我穿进去的明文 : " + authentication.getCredentials() + " password encoded : " + passwordEncoder.encode(authentication.getCredentials().toString()));

        if (passwordEncoder.matches(authentication.getCredentials().toString(), user.getPassword())) { //服务器开始匹配密码，raw pass在前，数据库密在后
            token.setDetails(authentication.getDetails()); //用户输入的授权放到Token授权中
            return token;
        } else {
            token.setAuthenticated(false);
            throw new BadCredentialsException("密码不正确");

        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals( //复写Provider为UsernamePasswordAuthentication
                UsernamePasswordAuthenticationToken.class);
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



