package com.osmium.java.schoolconnect.backend.config;

import com.osmium.java.schoolconnect.backend.mapper.UserMapper;
import com.osmium.java.schoolconnect.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @PostConstruct
    public void init(){
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
    }

    @Resource
    UserMapper userMapper;
    @Resource
    UserService authService;
    @Resource
    PersistentTokenRepository repository;

    @Bean
    public PersistentTokenRepository jdbcRepository(@Autowired DataSource dataSource){
        JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();  //使用基于JDBC的实现
        repository.setDataSource(dataSource);   //配置数据源
        return repository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/static/**", "/page/auth/**", "/api/auth/**").permitAll()
                .antMatchers("/page/user/**", "/api/user/**").hasRole("user")
                .antMatchers("/page/admin/**", "/api/admin/**").hasRole("admin")
                .anyRequest().hasAnyRole("user", "admin")
                .and()
                .formLogin()
                .loginPage("/page/auth/login")
                .loginProcessingUrl("/api/auth/login")
                .successHandler(this::onAuthenticationSuccess)
                .and()
                .logout()
                .logoutUrl("/api/auth/logout")
                .logoutSuccessUrl("/login")
                .and()
                .csrf().disable()
                .rememberMe()
                .rememberMeParameter("remember")
                .tokenValiditySeconds(60 * 60 * 24 * 7)
                .tokenRepository(repository);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(sysUserMapper)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    private void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        HttpSession session = httpServletRequest.getSession();
        User user = UserMapper.getPasswordByUsername(authentication.getName());
        session.setAttribute("user", user);
        if(user.getRole().equals("admin")){
            httpServletResponse.sendRedirect("/bookmanager/page/admin/index");
        }else {
            httpServletResponse.sendRedirect("/bookmanager/page/user/index");
        }
    }
}
