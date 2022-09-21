package com.osmium.java.schoolconnect.backend.controller;

import com.osmium.java.schoolconnect.backend.entity.User;
import com.osmium.java.schoolconnect.backend.service.UserService;
import com.osmium.java.schoolconnect.backend.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/auth")

public class AuthController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "用户登录", notes = "用户登录")
    @PostMapping("/login")
    public Result userLogin(User user) {
//        userService.get
        return Result.success();
    }


}
