package com.osmium.schoolconnect.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

import java.security.interfaces.RSAPublicKey;

/**
 * @Author Abel www.osmium.com
 * @Date 2023/2/6
 * @Description 对端点的安全配置
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity //必须添加 启用Security PrePost处理
public class EndpointsSecurityConfig {
    @Value("${jwt.cert.pub}")
    RSAPublicKey pub;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(allauthz -> allauthz
                        .requestMatchers("/ui/**").permitAll()
                        .requestMatchers("/v3/**").permitAll()
                        .requestMatchers("/doc**").permitAll()
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.ignoringRequestMatchers("/**")) //CSRF Demo Disable
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                //.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(exceptions -> exceptions //Exception
                        .authenticationEntryPoint(new GlobalAuthenticationHandler.CustomizedAuthenticationEntryPoint())
                        .accessDeniedHandler(new GlobalAuthenticationHandler.CustomizedAccessDeniedHandler())

                );

        return http.build();
    }

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(pub).build();
    }

}
