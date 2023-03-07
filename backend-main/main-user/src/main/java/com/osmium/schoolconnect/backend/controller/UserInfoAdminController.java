package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.User;
import com.osmium.schoolconnect.backend.service.IUserService;
import com.osmium.schoolconnect.backend.utils.annotations.SuperAccess;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/11
 * @Description
 */
@RestController
@SuperAccess
@RequestMapping("/admin/user/info")
public class UserInfoAdminController {
    private final IUserService iUserService;

    public UserInfoAdminController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @Operation(summary = "获取用户信息")
    @GetMapping
    public User getInfo(@RequestParam String userId) {
        return iUserService.getById(userId);
    }

    @Operation(summary = "添加用户信息")
    @PostMapping
    public Boolean addInfo(@RequestBody List<User> user) {
        return iUserService.saveBatch(user);
    }
    @Operation(summary = "修改用户信息")

    @PutMapping
    public Boolean updateInfo(@RequestBody User newUser) {
        return iUserService.updateById(newUser);

    }


}
