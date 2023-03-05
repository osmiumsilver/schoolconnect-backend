package com.osmium.schoolconnect.backend.controller;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.osmium.schoolconnect.backend.entity.DepartmentManagerInfo;
import com.osmium.schoolconnect.backend.misc.Result;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import com.osmium.schoolconnect.backend.service.IDepartmentManagerInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/20
 * @Description
 */
@RestController
@Slf4j
@RequestMapping("/department/manager")
public class DepartmentManagerController {

    private final IDepartmentManagerInfoService iDepartmentManagerInfoService;

    public DepartmentManagerController(IDepartmentManagerInfoService iDepartmentManagerInfoService) {
        this.iDepartmentManagerInfoService = iDepartmentManagerInfoService;
    }

    @GetMapping
    public Result<List<DepartmentManagerInfo>> getManagersByDepartment(@RequestParam List<DepartmentManagerInfo> managerId) {
        return Result.success(iDepartmentManagerInfoService.getManagersByDepartment(managerId));
    }
    @PostMapping
    public Result<JSONObject> addDepartmentManagers(@RequestBody List<DepartmentManagerInfo> departments) {
       iDepartmentManagerInfoService.saveBatch(departments);
       return Result.success();

    }

    @DeleteMapping
    public Result<JSONObject> deleteDepartmentManagers(@RequestBody List<DepartmentManagerInfo> departments) {
        if (iDepartmentManagerInfoService.removeBatchByIds(departments))
            return Result.success();
        else return Result.error(ResultCode.DATA_MANIPULATION_ERROR);
    }

    @PutMapping
    public Result<JSONObject> updateDepartmentManagers(@RequestBody List<DepartmentManagerInfo> departments) {
        if (iDepartmentManagerInfoService.updateBatchById(departments))
            return Result.success();
        else return Result.error(ResultCode.DATA_MANIPULATION_ERROR);
    }



}
