package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.User;
import com.osmium.schoolconnect.backend.misc.APIException;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import com.osmium.schoolconnect.backend.service.IUserService;
import com.osmium.schoolconnect.backend.utils.SecurityUtils;
import com.osmium.schoolconnect.backend.utils.annotations.AccessIsolation;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

/**
 * @Author
 * @Date 2023/2/11
 * @Description 学生操作学籍
 */
@RestController
@RequestMapping("/user/info")
public class UserInfoControllerForUsers {
    private final IUserService iUserService;

    public UserInfoControllerForUsers(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @Operation(summary = "用户端获取自身信息")
    @GetMapping
    public User getInfo(Authentication authentication) {
        return iUserService.getById(authentication.getName());
    }

    @Operation(summary = "学生修改学籍信息")

    @PutMapping
    public Boolean updateInfo(@RequestBody User newUser) {
        if(!newUser.getEmployeeId().equals(SecurityUtils.getUserId()))
            throw new APIException(ResultCode.AUTH_NO_PERMISSION);
        return iUserService.updateById(newUser);
    }



}
