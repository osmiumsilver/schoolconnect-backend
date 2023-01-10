package com.osmium.schoolconnect.backend.auth.oauth2resourceserver;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.oauth2.jwt.Jwt;
/**
 * @Author
 * @Date 2022/12/7
 * @Description
 */
@RestController
public class OAuth2ResourceServerController {
    @GetMapping("/")
    public String index(@AuthenticationPrincipal Jwt jwt)
    {
        return String.format("Hello, %s!",jwt.getSubject());
    }
    @GetMapping("/message")
    public String message() {
        return "secret message";
    }
}
