package com.osmium.schoolconnect.backend.auth.utils;

import com.osmium.schoolconnect.backend.auth.config.SecurityConstants;
import com.osmium.schoolconnect.backend.auth.entity.Login;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * @Author
 * @Date 2022/11/2
 * @Description
 */

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
private final AuthenticationManager authenticationManager;

        public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
                this.authenticationManager = authenticationManager;
                setFilterProcessesUrl(SecurityConstants.AUTH_LOGIN_URL);
        }

        @Override
        public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
                var username=request.getParameter("username");
                var password=request.getParameter("password");
                return new UsernamePasswordAuthenticationToken(username, password);
        }

        @Override
        protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
             var user = ((Login) authResult.getPrincipal());
             var roles = user.getAuthorities()
                     .stream()
                     .map(GrantedAuthority::getAuthority)
                     .collect(Collectors.toList());
             var signingKey =SecurityConstants.JWT_SECRET.getBytes();
             var token = Jwts.builder()
                     .signWith(Keys.hmacShaKeyFor(signingKey), SignatureAlgorithm.HS512)
                     .setHeaderParam("typ",SecurityConstants.TOKEN_TYPE)
                     .setIssuer(SecurityConstants.TOKEN_ISSUER)
                     .setAudience(SecurityConstants.TOKEN_AUDIENCE)
                     .setSubject(user.getUsername())
                     .setExpiration(new Date(System.currentTimeMillis()+86400000))
                     .claim("rol",roles)
                     .compact();
             response.addHeader(SecurityConstants.TOKEN_HEADER,SecurityConstants.TOKEN_PREFIX+token);
        }
}
