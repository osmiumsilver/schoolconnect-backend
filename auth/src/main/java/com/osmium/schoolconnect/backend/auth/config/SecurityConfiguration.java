package com.osmium.schoolconnect.backend.auth.config;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @Author
 * @Date 2022/11/1
 * @Description
 */

@Configuration
@EnableWebSecurity

public class SecurityConfiguration{

    @Value("${jwt.public.key}")
    RSAPublicKey key;

    @Value("${jwt.private.key}")
    RSAPrivateKey priv;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(authz -> authz
                //.requestMatchers("**").permitAll()
                .requestMatchers("/api/login").permitAll()
                        .requestMatchers("/api/token").permitAll()

                //.antMatchers("/api/class/**").hasRole("USER")
                .anyRequest().authenticated())
                .csrf(csrf->csrf.ignoringRequestMatchers("/api/token"))
                .httpBasic(Customizer.withDefaults())
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                //.addFilter(new JwtAuthenticationFilter(authenticationManager()))
                //.addFilter(new JwtAuthorizationFilter(authenticationManager()))
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .exceptionHandling(exceptions -> exceptions
                .authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
                .accessDeniedHandler(new BearerTokenAccessDeniedHandler()));
        return http.build();
    }

    //@Bean
    //public WebSecurityCustomizer webSecurityCustomizer(){
    //    return web -> web.ignoring().requestMatchers("/api/login");
    //}

    @Bean
    public InMemoryUserDetailsManager userDetailsService(){ //Only for testing purpose
        UserDetails user = User.builder()
                .username("user")
                .password("{noop}password")
                .authorities("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}password")
                .roles("ADMIN","USER")
                .build();
        return new InMemoryUserDetailsManager(user,admin);
    }



   @Bean
    JwtDecoder jwtDecoder()
   {
       return NimbusJwtDecoder.withPublicKey(this.key).build();
   }
   @Bean
    JwtEncoder jwtEncoder() {
       JWK jwk = new RSAKey.Builder(this.key).privateKey(this.priv).build();
       JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
       return new NimbusJwtEncoder(jwks);
   }
    //@Bean
    //public CorsConfigurationSource corsConfigurationSource() {
    //    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    //    source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
    //
    //    return source;
    //}


}

