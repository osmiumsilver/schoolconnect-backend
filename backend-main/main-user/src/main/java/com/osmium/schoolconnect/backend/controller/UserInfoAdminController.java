package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.User;
import com.osmium.schoolconnect.backend.service.IUserService;
import com.osmium.schoolconnect.backend.utils.annotations.SuperAccess;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @Author
 * @Date 2023/2/11
 * @Description
 */
@RestController
@SuperAccess
@RequestMapping("/admin/user/info")
@Tag(name = "用户信息管理员")
public class UserInfoAdminController {
    private final IUserService iUserService;

    public UserInfoAdminController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @Operation(summary = "获取用户信息")
    @GetMapping
    public List<User> getInfo(@RequestParam String userId) {
        return iUserService.listByIds(Collections.singleton(userId));
    }
    @Operation(summary = "获取用户信息")
    @GetMapping("/detail")
    public User getSingletonInfo(@RequestParam String userId) {
        return iUserService.getById(userId);
    }

    @Operation(summary = "添加用户信息")
    @PostMapping
    public Boolean addInfo(@RequestBody List<User> user) {
        return iUserService.saveBatch(user);
    }
    @Operation(summary = "修改用户信息")

    @PatchMapping
    public Boolean updateInfo(@RequestBody List<User> newUser) {
        return iUserService.updateBatchById(newUser);

    }


}
