package com.osmium.schoolconnect.backend.auth.controller;


import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/api")
@Slf4j
@Validated
public class LoginController {

@GetMapping("/login")
    public String getMessage()
{
    return "Welcome to the;";
}
}

