package com.osmium.schoolconnect.backend.config;

import com.osmium.schoolconnect.backend.service.ILoginService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
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
    @Resource
    private final ILoginService iLoginService;

    public CustomAuthenticationProvider(ILoginService iLoginService) {
        this.iLoginService = iLoginService;
    }

    @Resource //把SHA256加密器从容器内给拿过来
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) {
        final String username = (authentication.getPrincipal() == null) ? "未提供" : authentication.getName();
        if (username.equals("未提供")) {
            authentication.setAuthenticated(false);
            throw new BadCredentialsException("未提供账号");
        } else return createAuthentication(authentication, iLoginService.loadUserByUsername(username));
    }

    //传两个参数 一个是用户请求的 一个是数据库中存在的 //user是数据库来的 authentication是我登录时候给出的
    private Authentication createAuthentication(final Authentication authentication, final UserDetails user) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), authentication.getCredentials(), user.getAuthorities());
        log.trace("数据库中的密码： (Password in my database )" + user.getPassword() + " " + "我穿进去的明文 : " + authentication.getCredentials() + " password encoded : " + passwordEncoder.encode(authentication.getCredentials().toString()));

        if (passwordEncoder.matches(authentication.getCredentials().toString(), user.getPassword())) { //服务器开始匹配密码，raw pass在前，数据库密在后
            if (!user.isAccountNonExpired() || !user.isAccountNonLocked() || !user.isEnabled()) {
                token.setAuthenticated(false);
                throw new LockedException("Account Locked");
            }
            token.setDetails(authentication.getDetails()); //用户输入的授权放到Token授权中
            return token;
        } else {
            token.setAuthenticated(false);
            return token;

        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
    //放在下面参考 现在用不到
    //private Authentication tryAuthWithDatabase(final String username,final String password){
    // UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken();
    //    return UsernamePasswordAuthenticationToken.unauthenticated(username, password);
    //
    //} else {
    //        Collection<? extends GrantedAuthority> authorities = result.getAuthorities();
    //        return UsernamePasswordAuthenticationToken.authenticated(username, password, authorities);
    //}
}



