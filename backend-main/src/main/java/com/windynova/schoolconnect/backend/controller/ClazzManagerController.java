package com.osmium.schoolconnect.backend.controller;

import cn.hutool.json.JSONObject;
import com.osmium.schoolconnect.backend.entity.Clazz;
import com.osmium.schoolconnect.backend.entity.ClazzManagerInfo;
import com.osmium.schoolconnect.backend.entity.CourseInfo;
import com.osmium.schoolconnect.backend.entity.User;
import com.osmium.schoolconnect.backend.misc.AuthorityCode;
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
 * @Description  班级管理人员控制器
 */

@RestController
@RequestMapping("/class/class_manager")
public class ClazzManagerController {
    private final IClazzManagerInfoService iClazzManagerInfoService;

    public ClazzManagerController(IClazzManagerInfoService iClazzManagerInfoService) {
        this.iClazzManagerInfoService = iClazzManagerInfoService;
    }

    @Operation(summary = "获取班级下的管理人员", description = "获取所有班级信息")
    @GetMapping("/")
    public Result<List<ClazzManagerInfo>> getClazzManagersByClazz() {
        return Result.success(iClazzManagerInfoService.list());
    }



    @Operation(summary = "添加班级", description = "传入班级信息")
    @PostMapping
    public Result<JSONObject> addClazzManagers(@RequestBody List<ClazzManagerInfo> clazzes) {
        if (iClazzManagerInfoService.saveOrUpdateBatch(clazzes))
            return Result.success();
        else return Result.error();
    }

    @PutMapping
    public Result<JSONObject> updateClazzManagers(@RequestBody List<ClazzManagerInfo> clazzes) {
        if (iClazzManagerInfoService.updateBatchById(clazzes))
            return Result.success();
        else return Result.error(ResultCode.DATA_MANIPULATION_ERROR);
    }

    @DeleteMapping
    public Result<JSONObject> deleteClazzManagers(@RequestBody List<ClazzManagerInfo> clazzes) {
        if (iClazzManagerInfoService.removeBatchByIds(clazzes))
            return Result.success();
        else return Result.error(ResultCode.DATA_MANIPULATION_ERROR);
    }
}

