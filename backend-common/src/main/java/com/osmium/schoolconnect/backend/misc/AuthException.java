package com.osmium.schoolconnect.backend.misc;

import org.springframework.security.core.AuthenticationException;

/**
 * @Author
 * @Date 2023/3/17
 * @Description
 */
public class AuthException extends AuthenticationException {
    public AuthException(String msg) {
        super(msg);
    }

    public AuthException(StatusCode statusCode) {

        super(statusCode.getMsg());
}
}
