package com.osmium.schoolconnect.backend.config;

import com.osmium.schoolconnect.backend.misc.GlobalAuthenticationHandler;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

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
    @Resource
 CorsConfigurationSource corsConfigurationSource;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(allauthz -> allauthz
                        .requestMatchers( "/v3/**", "/doc**", "/webjars/**","/graphiql","/graphql").permitAll()
                        .requestMatchers("/ui/**").permitAll()
                        .requestMatchers("/favicon.ico").permitAll()
                        .requestMatchers("/logout").permitAll()
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.ignoringRequestMatchers("/**")) //CSRF Demo Disable

                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                //.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(exceptions -> exceptions //Exception
                        .authenticationEntryPoint(new GlobalAuthenticationHandler.CustomizedAuthenticationEntryPoint())
                        .accessDeniedHandler(new GlobalAuthenticationHandler.CustomizedAccessDeniedHandler())

                )
        ;

        return http.build();
    }

    //Some wacky Implementations of THIS SHIT \\ ROLE ? AUTHORITY ? SCOPE  ? ??? WTF IS ALL THIS
    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {

        JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        grantedAuthoritiesConverter.setAuthorityPrefix("");

        JwtAuthenticationConverter authConverter = new JwtAuthenticationConverter();
        authConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
        return authConverter;
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(pub).build();
    }

}
