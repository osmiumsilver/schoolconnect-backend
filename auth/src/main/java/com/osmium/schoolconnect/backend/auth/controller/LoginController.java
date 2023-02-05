package com.osmium.schoolconnect.backend.auth.controller;

import com.osmium.schoolconnect.backend.auth.service.ILoginService;
import com.osmium.schoolconnect.backend.auth.entity.Login;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author
 * @Date 2023/2/3
 * @Description
 */
@RestController
@RequestMapping("/auth")
public class LoginController {


    @Resource
    private ILoginService loginService;

    @PostMapping("/login")
    public Login login(String username, String password, String timestamp)
    {
        return loginService.login(username,password);
    }
}
