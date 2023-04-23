package com.osmium.schoolconnect.backend.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.osmium.schoolconnect.backend.entity.User;
import com.osmium.schoolconnect.backend.entity.pojo.UninitializedUsers;
import com.osmium.schoolconnect.backend.service.ILoginService;
import com.osmium.schoolconnect.backend.service.IUnUsers;
import com.osmium.schoolconnect.backend.service.IUserService;
import com.osmium.schoolconnect.backend.utils.annotations.SuperAccess;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    private final ILoginService iLoginService;
    final PasswordEncoder passwordEncoder;
private final IUnUsers iUnUsers;


    public UserInfoAdminController(IUserService iUserService, ILoginService iLoginService, PasswordEncoder passwordEncoder, IUnUsers iUnUsers) {
        this.iUserService = iUserService;
        this.iLoginService = iLoginService;
        this.passwordEncoder = passwordEncoder;
        this.iUnUsers = iUnUsers;
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
    @Operation(summary = "锁定用户信息")

    @PatchMapping("/lock")
    public Boolean lockAccount(@RequestBody List<User> newUser) {
        newUser.forEach(user ->{
            user.setStatus((byte) 3);
        });
        return iUserService.updateBatchById(newUser);
        
    } @Operation(summary = "解锁用户信息")

    @PatchMapping("/unlock")
    public Boolean unlockAccount(@RequestBody List<User> newUser) {
        newUser.forEach(user ->{
            user.setStatus((byte) 0);
        });
        return iUserService.updateBatchById(newUser);

    }

    @Operation(summary = "查询未初始化的账户")
    @SuperAccess
    @GetMapping("/nopassword")
    public List<UninitializedUsers> getUninitializedUsers() {
     return iUnUsers.list();

    }

    @Operation(summary = "重置个人密码")
    @SuperAccess
    @PostMapping("/setdefaultpass")
    public Object setDefaultPass(@RequestBody List<String> userIds) {
        var statusMap = new HashMap<String, Integer>();
        for (String userId : userIds) {
            if (iLoginService.updatePassword(userId, passwordEncoder.encode("123456")).equals(false)) {
                statusMap.put(userId, 1);
            }
            statusMap.put(userId, 0);
        }
        List<String> userWhoFailedChanging = new ArrayList<String>();

        for (Map.Entry<String, Integer> next : statusMap.entrySet()) {
            if (next.getValue() == 1)
                userWhoFailedChanging.add(next.getKey());
        }
        if (userWhoFailedChanging.isEmpty())
            return true;
        else return userWhoFailedChanging;
    }


}
