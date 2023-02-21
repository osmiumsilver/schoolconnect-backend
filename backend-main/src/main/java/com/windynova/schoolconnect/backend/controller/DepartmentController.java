package com.osmium.schoolconnect.backend.controller;

import cn.hutool.json.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.osmium.schoolconnect.backend.entity.DepartmentInfo;
import com.osmium.schoolconnect.backend.misc.Result;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import com.osmium.schoolconnect.backend.service.IDepartmentInfoService;
import com.osmium.schoolconnect.backend.service.IDepartmentManagerInfoService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.sql.Date;
import java.util.List;

/**
 * @Author
 * @Date 2023/2/20
 * @Description
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final IDepartmentInfoService iDepartmentInfoService;
    private final IDepartmentManagerInfoService iDepartmentManagerInfoService;

    public DepartmentController(IDepartmentInfoService iDepartmentInfoService, IDepartmentManagerInfoService iDepartmentManagerInfoService) {
        this.iDepartmentInfoService = iDepartmentInfoService;
        this.iDepartmentManagerInfoService = iDepartmentManagerInfoService;
    }

    @GetMapping
    public Result<List<DepartmentInfo>> getAllDepartments() {
        return Result.success(iDepartmentInfoService.list());
    }

    @DeleteMapping
    public Result<JSONObject> deleteDepartments(@PathVariable List<DepartmentInfo> departments) {
        if (iDepartmentInfoService.removeBatchByIds(departments))
            return Result.success();
        else return Result.error(ResultCode.TODO);
    }

    @PutMapping
    public Result<JSONObject> updateDepartments(@PathVariable List<DepartmentInfo> departments) {
        if (iDepartmentInfoService.updateBatchById(departments))
            return Result.success();
        else return Result.error(ResultCode.TODO);
    }
    @PostMapping
    public Result<JSONObject> addDepartments(@PathVariable List<DepartmentInfo> departments) {
        if(iDepartmentInfoService.saveBatch(departments))
            return Result.success();
        else return Result.error(ResultCode.TODO);
    }

}
