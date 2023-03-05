package com.osmium.schoolconnect.backend.config;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import com.osmium.schoolconnect.backend.misc.FilterChainExceptionHandler;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.List;

/**
 * @Author Abel www.osmium.com
 * @Date 2022/11/1
 * @Description Security configuration for the authorization server.
 */

@Configuration
@EnableWebSecurity
public class AuthSecurityConfiguration {


    //@Autowired 直接Bean注入 不需要AutoWired
    //private CustomAuthenticationProvider customAuthenticationProvider;
    @Value("${jwt.cert.pub}")
    RSAPublicKey pub;

    @Value("${jwt.cert.key}")
    RSAPrivateKey key;

    @Resource
    private FilterChainExceptionHandler filterChainExceptionHandler;
   /*
    Completely bypass the filter and we dont use that here.
    */
    //@Bean
    //public WebSecurityCustomizer webSecurityCustomizer() { //
    //    return (web) -> web.ignoring().requestMatchers("/auth/**");
    //}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authz -> authz
                        .anyRequest().permitAll()
                )
                //.addFilterBefore(filterChainExceptionHandler, LogoutFilter.class)
                .csrf(csrf -> csrf.ignoringRequestMatchers("/auth/**")) //CSRF Demo Disable
                .httpBasic(Customizer.withDefaults()) //Basic方式授权
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(exceptions -> exceptions //Exception 处理
                        .authenticationEntryPoint(new GlobalAuthenticationHandler.CustomizedAuthenticationEntryPoint())
                        .accessDeniedHandler(new GlobalAuthenticationHandler.CustomizedAccessDeniedHandler())
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, UserDetailsService userDetailsService, CustomAuthenticationProvider customAuthenticationProvider) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService).passwordEncoder(passwordEncoder())
                .and()
                .authenticationProvider(customAuthenticationProvider)
                .build();
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

    @Value("#{'${cors.allowed-origins}'.split(',')}")
    private List<String> allowedOrigins;

    @Value("#{'${cors.allowed-methods}'.split(',')}")
    private List<String> allowedMethods;

    @Value("#{'${cors.allowed-headers}'.split(',')}")
    private List<String> allowedHeaders;

    @Value("#{'${cors.exposed-headers}'.split(',')}")
    private List<String> expectedHeaders;

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(allowedOrigins);
        config.setAllowedMethods(allowedMethods);
        config.setAllowedHeaders(allowedHeaders);
        config.setExposedHeaders(expectedHeaders);        // 暴露 header 中的其他属性给客户端应用程序
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration(config));
        return source;
    }

}
