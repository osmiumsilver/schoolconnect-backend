package com.osmium.schoolconnect.backend.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author
 * @Date 2023/3/5
 * @Description
 */
@RestController
@RequestMapping("/i")
public class AuthorityTestController {
   @GetMapping
    public String getMyInfo (Authentication authentication)
   {
       return authentication.getAuthorities().toString();
   }
}
