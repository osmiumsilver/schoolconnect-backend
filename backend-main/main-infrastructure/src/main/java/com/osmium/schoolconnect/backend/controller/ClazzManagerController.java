package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.ClazzManagerInfo;
import com.osmium.schoolconnect.backend.service.IClazzManagerInfoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Author Abel
 * @date 2022/3/30
 * @Description 班级管理人员控制器
 */

@RestController
@RequestMapping("/class/manager")
public class ClazzManagerController {
    private final IClazzManagerInfoService iClazzManagerInfoService;

    public ClazzManagerController(IClazzManagerInfoService iClazzManagerInfoService) {
        this.iClazzManagerInfoService = iClazzManagerInfoService;
    }

    @Operation(summary = "获取班级下的管理人员")
    @GetMapping
    public List<ClazzManagerInfo> getClazzManagersByClazz() {
        return iClazzManagerInfoService.list();
    }

    @Operation(summary = "添加班级管理人员")
    @PostMapping
    public Boolean addClazzManagers(@RequestBody List<ClazzManagerInfo> clazzes) {
        return iClazzManagerInfoService.saveOrUpdateBatch(clazzes);
    }

    @Operation(summary = "修改班级管理人员")
    @PutMapping
    public Boolean updateClazzManagers(@RequestBody List<ClazzManagerInfo> clazzes) {
        return iClazzManagerInfoService.updateBatchById(clazzes);
    }

    @Operation(summary = "删除班级管理人员")
    @DeleteMapping
    public Boolean deleteClazzManagers(@RequestBody List<ClazzManagerInfo> clazzes) {
        return iClazzManagerInfoService.removeBatchByIds(clazzes);
    }
}

