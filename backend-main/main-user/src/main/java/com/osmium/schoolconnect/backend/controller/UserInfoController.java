package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.User;
import com.osmium.schoolconnect.backend.service.IUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/11
 * @Description
 */
@RestController
@RequestMapping("/user/info")
public class UserInfoController {
    private final IUserService iUserService;

    public UserInfoController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @GetMapping
    public User getInfo(@RequestParam String userId) {
        return iUserService.getById(userId);
    }


    @PostMapping
    public Boolean addInfo(@RequestBody List<User> user) {
        return iUserService.saveBatch(user);
    }

    @PutMapping
    public Boolean updateInfo(@RequestBody User newUser) {
        return iUserService.updateById(newUser);

    }


}
