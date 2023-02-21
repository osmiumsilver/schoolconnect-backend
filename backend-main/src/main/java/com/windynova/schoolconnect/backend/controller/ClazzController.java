package com.osmium.schoolconnect.backend.controller;

import cn.hutool.json.JSONObject;
import com.osmium.schoolconnect.backend.entity.Clazz;
import com.osmium.schoolconnect.backend.misc.AuthorityCode;
import com.osmium.schoolconnect.backend.misc.Result;
import com.osmium.schoolconnect.backend.service.IClazzService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Author Abel
 * @date 2022/3/30
 * @Description  班级控制器
 */

@RestController
@RequestMapping("/class")
public class ClazzController {
    private final IClazzService clazzService;

    public ClazzController(IClazzService clazzService) {
        this.clazzService = clazzService;
    }


    @Operation(summary = "获取所有班级信息", description = "获取所有班级信息")
    @GetMapping("/")
    public Result<List<Clazz>> queryAllClazzes() {
        return Result.success(clazzService.list());
    }


    @Operation(summary = "添加班级", description = "传入班级信息")
    @PostMapping
    public Result<JSONObject> addClazz(@RequestBody List<Clazz> clazzes) {
        if (clazzService.saveOrUpdateBatch(clazzes))
            return Result.success();
        else return Result.error();
    }

    @Operation(summary = "查询班级", description = "查询班主任或辅导员管理下班级")
    @GetMapping
    public Result<List<Clazz>> getClazzByStaff(@RequestParam String userId, AuthorityCode authorityCode) {
        return Result.success(clazzService.getClazzManagedByStaff(userId,authorityCode.getCode()));
    }


}

