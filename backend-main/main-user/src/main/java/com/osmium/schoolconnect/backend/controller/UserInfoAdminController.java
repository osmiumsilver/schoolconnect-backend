package com.osmium.schoolconnect.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.osmium.schoolconnect.backend.entity.User;
import com.osmium.schoolconnect.backend.entity.pojo.StudentInfoVO;
import com.osmium.schoolconnect.backend.entity.pojo.UninitializedUsers;
import com.osmium.schoolconnect.backend.service.ILoginService;
import com.osmium.schoolconnect.backend.service.IUninitializedUsers;
import com.osmium.schoolconnect.backend.service.IUserService;
import com.osmium.schoolconnect.backend.utils.ExcelUtils;
import com.osmium.schoolconnect.backend.utils.annotations.SuperAccess;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    private final IUninitializedUsers iUninitializedUsers;

    @Value("/Users/abel/log/excel/")
    private String path;
    public UserInfoAdminController(IUserService iUserService, ILoginService iLoginService, PasswordEncoder passwordEncoder, IUninitializedUsers iUninitializedUsers) {
        this.iUserService = iUserService;
        this.iLoginService = iLoginService;
        this.passwordEncoder = passwordEncoder;
        this.iUninitializedUsers = iUninitializedUsers;
    }

    @Operation(summary = "获取用户信息")
    @GetMapping
    public List<User> getInfo(@RequestParam String userId) {
        return iUserService.listByIds(Collections.singleton(userId));

    }
    @Operation(summary = "查询该班级下面的学生")
    @GetMapping("/by_class")
    public List<StudentInfoVO> getInfoByClazz(@RequestParam String clazzId) {
        return iUserService.listStudentInfoByClazzId(clazzId);
    }



    @PostMapping("/export/blank")
    public void exportBlank(HttpServletResponse response) throws IOException {
        List<User> userList = iUserService.list(Wrappers.emptyWrapper());
        //导出操作
        ExcelUtils.exportExcel(userList, "用户信息", "Sheet1", User.class, "users", response);
    }
    @PostMapping("/export/class")
    public void export(HttpServletResponse response) throws IOException {
        QueryWrapper q=new QueryWrapper();
        List<User> userList = iUserService.list();
        //导出操作
        ExcelUtils.exportExcel(userList, "用户信息", "Sheet1", User.class, "users", response);
    }

    @PostMapping("/import")
    public Boolean importExcel(@RequestPart MultipartFile file) throws IOException {

     var userList = ExcelUtils.importExcel(file,1,1,User.class);

        return iUserService.saveBatch(userList);
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
        newUser.forEach(user -> {
            user.setStatus((byte) 3);
        });
        return iUserService.updateBatchById(newUser);

    }

    @Operation(summary = "解锁用户信息")

    @PatchMapping("/unlock")
    public Boolean unlockAccount(@RequestBody List<User> newUser) {
        newUser.forEach(user -> {
            user.setStatus((byte) 0);
        });
        return iUserService.updateBatchById(newUser);

    }

    @Operation(summary = "查询未初始化的账户")
    @SuperAccess
    @GetMapping("/nopassword")
    public List<UninitializedUsers> getUninitializedUsers() {
        return iUninitializedUsers.list();

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
        List<String> userWhoFailedChanging = new ArrayList<>();

        for (Map.Entry<String, Integer> next : statusMap.entrySet()) {
            if (next.getValue() == 1)
                userWhoFailedChanging.add(next.getKey());
        }
        if (userWhoFailedChanging.isEmpty())
            return true;
        else return userWhoFailedChanging;
    }


}
