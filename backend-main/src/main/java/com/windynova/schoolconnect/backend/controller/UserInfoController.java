package com.osmium.schoolconnect.backend.controller;

import cn.hutool.json.JSONObject;
import com.osmium.schoolconnect.backend.entity.Grade;
import com.osmium.schoolconnect.backend.entity.User;
import com.osmium.schoolconnect.backend.misc.Result;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import com.osmium.schoolconnect.backend.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/11
 * @Description
 */
@RestController
@RequestMapping("/employee")
public class UserInfoController {
    private final IUserService iUserService;
    public UserInfoController(IUserService iUserService) {
        this.iUserService = iUserService;
    }


    @GetMapping
    public Result<User> getInfo(@RequestParam String userId) {
        return Result.success(iUserService.getById(userId));
    }


    @PostMapping
    public Result<JSONObject> setGrade(@RequestBody List<User> grade) {
       iUserService.saveBatch(grade);
            return Result.success();

    }

    @PutMapping
    public Result<JSONObject> updateInfo(@RequestBody User newUser) {
        if (iUserService.updateById(newUser)) {
            return Result.success();
        } else return Result.error(ResultCode.DB_SQL_SYNTAX_ERR);
    }
}
