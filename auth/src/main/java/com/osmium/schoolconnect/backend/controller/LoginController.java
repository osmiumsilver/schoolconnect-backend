package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.Login;
import com.osmium.schoolconnect.backend.service.ILoginService;
import com.osmium.schoolconnect.backend.service.impl.LoginServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
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
