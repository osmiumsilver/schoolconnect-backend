package com.osmium.schoolconnect.backend.controller;

import cn.hutool.json.JSONObject;
import com.osmium.schoolconnect.backend.entity.Clazz;
import com.osmium.schoolconnect.backend.misc.Result;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import com.osmium.schoolconnect.backend.service.IClazzManagerInfoService;
import com.osmium.schoolconnect.backend.service.IClazzService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Author Abel
 * @date 2022/3/30
 * @Description 班级控制器
 */

@RestController
@RequestMapping("/class/class")
public class ClazzController {
    private final IClazzService iClazzService;
    private final IClazzManagerInfoService iClazzManagerInfoService;

    public ClazzController(IClazzService iClazzService, IClazzManagerInfoService iClazzManagerInfoService) {
        this.iClazzService = iClazzService;
        this.iClazzManagerInfoService = iClazzManagerInfoService;
    }


    @Operation(summary = "获取所有班级信息", description = "获取所有班级信息")
    @GetMapping("/")
    public Result<List<Clazz>> queryAllClazzes() {
        return Result.success(iClazzService.list());
    }

    @Operation(summary = "获取教师下管理的班级信息", description = "获取所有班级信息")
    @GetMapping
    public Result<List<Clazz>> getClazzManagedByStaff(@RequestParam String employeeId) {
        return Result.success(iClazzManagerInfoService.getClazzManagedByStaff(employeeId));
    }

    @Operation(summary = "添加班级信息", description = "添加班级")
    @PostMapping
    public Result<JSONObject> addClazz(@RequestBody List<Clazz> clazzes) {
        if (iClazzService.saveBatch(clazzes))
            return Result.success();
        else return Result.error(ResultCode.DATA_MANIPULATION_ERROR);
    }

    @Operation(summary = "修改班级信息", description = "修改班级信息")
    @PutMapping
    public Result<JSONObject> updateCourses(@RequestBody List<Clazz> clazzes) {
        if (iClazzService.updateBatchById(clazzes))
            return Result.success();
        else return Result.error(ResultCode.DATA_MANIPULATION_ERROR);
    }

    @Operation(summary = "删除班级信息", description = "删除班级信息")
    @DeleteMapping
    public Result<JSONObject> deleteCourses(@RequestBody List<Clazz> clazzes) {
        if (iClazzService.removeBatchByIds(clazzes))
            return Result.success();
        else return Result.error(ResultCode.DATA_MANIPULATION_ERROR);
    }
}

