package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.Clazz;
import com.osmium.schoolconnect.backend.misc.Result;
import com.osmium.schoolconnect.backend.service.IClazzService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/22
 * @Description
 */
@RestController
@RequestMapping("class/detail")
public class ClazzInfoController {
    private final IClazzService iClazzService;
    public ClazzInfoController(IClazzService iClazzService) {
        this.iClazzService = iClazzService;
    }
    @Operation(summary = "获取班级信息详细", description = "获取所有班级信息详细")
    @GetMapping
    public Result<List<Clazz>> queryClazzInfoById(@RequestParam List<Clazz> clazzes){
        return Result.success(iClazzService.listByIds(clazzes));
    }

}
