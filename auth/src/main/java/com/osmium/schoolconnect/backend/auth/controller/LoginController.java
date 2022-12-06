package com.osmium.schoolconnect.backend.auth.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author
 * @Date 2022/11/1
 * @Description
 */
@RestController
@Slf4j
@Validated
public class LoginController {

@GetMapping("/login")
    public String authenticateLogin(Authentication authentication)
{
    return "Welcome to the" + authentication.getName();
}
}

