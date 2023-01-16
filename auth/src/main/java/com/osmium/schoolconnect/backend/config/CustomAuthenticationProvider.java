package com.osmium.schoolconnect.backend.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @Author
 * @Date 2023/1/13
 * @Description
 */

    @Component
    public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

	        /*
	        if (shouldAuthenticateAgainstThirdPartySystem()) {
	        use the credentials
	        and authenticate against the third-party system
	        } else {
	            return null;
	        }
	        */

        return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                UsernamePasswordAuthenticationToken.class);
    }

}

