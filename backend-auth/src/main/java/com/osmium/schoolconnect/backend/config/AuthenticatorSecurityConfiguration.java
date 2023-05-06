package com.osmium.schoolconnect.backend.config;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import com.osmium.schoolconnect.backend.misc.GlobalAuthenticationHandler;
import com.osmium.schoolconnect.backend.service.impl.LogoutSuccessHandlerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @Author Abel www.osmium.com
 * @Date 2022/11/1
 * @Description Security configuration for the authorization server.
 */

@Configuration
@EnableWebSecurity(debug = true)
public class AuthenticatorSecurityConfiguration {
    private final LogoutSuccessHandlerImpl logoutSuccessHandlerImpl;

    //@Autowired 直接Bean注入 不需要AutoWired
    //private CustomAuthenticationProvider customAuthenticationProvider;
    @Value("${jwt.cert.pub}")
    RSAPublicKey pub;

    @Value("${jwt.cert.key}")
    RSAPrivateKey key;
    @Autowired
    public AuthenticatorSecurityConfiguration(LogoutSuccessHandlerImpl logoutSuccessHandlerImpl) {
        this.logoutSuccessHandlerImpl = logoutSuccessHandlerImpl;
    }

   /*
    Completely bypass the filter and we don't use that here.
    */
    //@Bean
    //public WebSecurityCustomizer webSecurityCustomizer() { //
    //    return (web) -> web.ignoring().requestMatchers("/auth/**");
    //}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.
                cors(Customizer.withDefaults())
                .authorizeHttpRequests(authz -> authz.requestMatchers("/auth/wxlogin").permitAll()
                        .requestMatchers("/logout").permitAll()
                        .requestMatchers("/favicon.ico").permitAll()
                        .anyRequest().authenticated())
                .csrf(AbstractHttpConfigurer::disable) //CSRF Demo Disable
                .httpBasic(withDefaults()) //Basic方式授权
                .formLogin().disable()
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(exceptions -> exceptions //Exception 处理
                        .authenticationEntryPoint(new GlobalAuthenticationHandler.CustomizedAuthenticationEntryPoint())
                        .accessDeniedHandler(new GlobalAuthenticationHandler.CustomizedAccessDeniedHandler())
                )
        .logout().logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandlerImpl)
        ;
        return http.build();
    }

    @Bean //passwordEncoder装进容器
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, UserDetailsService userDetailsService, CustomAuthenticationProvider customAuthenticationProvider) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(userDetailsService).passwordEncoder(passwordEncoder()).and().authenticationProvider(customAuthenticationProvider).build();
    }


    //Code for DEMO 这个是内存临时的用户
    //@Bean
    //public InMemoryUserDetailsManager userDetailsService(){ //Only for testing purpose
    //    UserDetails user = User.builder()
    //            .username("user")
    //            .password("{noop}password")
    //            .authorities("USER")
    //            .build();
    //    UserDetails admin = User.builder()
    //            .username("admin")
    //            .password("{noop}password")
    //            .roles("ADMIN","USER")
    //            .build();
    //    return new InMemoryUserDetailsManager(user,admin);
    //}

    /**
     @author Abel
     @Description JWT It's not about the encryption , but about signing and confirm authenticity. RSA can be used for signing schemes. That's all about it.
     @Description JWT不在于加密信息，而是保证信息的真实完整
     */

    //@Bean
    //JwtDecoder jwtDecoder() { //verify using pub
    //    return NimbusJwtDecoder.withPublicKey(pub).build();
    //}

    /**
     * @return 返回签署的Jwk
     * @author Abel
     */
    @Bean
    JwtEncoder jwtEncoder() { //Sign with private
        JWK jwk = new RSAKey.Builder(this.pub).privateKey(this.key).build(); //Builder来生成jwk
        JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk)); //jwksourced by jwkeys 分装成JWKSource
        return new NimbusJwtEncoder(jwks);
    }


}

