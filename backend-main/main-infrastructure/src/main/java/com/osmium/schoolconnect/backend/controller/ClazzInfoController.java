package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.Clazz;
import com.osmium.schoolconnect.backend.service.IClazzManagerInfoService;
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
@RequestMapping("/class/detail")
public class ClazzInfoController {
    private final IClazzService iClazzService;
    private final IClazzManagerInfoService iClazzManagerInfoService;
    public ClazzInfoController(IClazzService iClazzService, IClazzManagerInfoService iClazzManagerInfoService) {
        this.iClazzService = iClazzService;
        this.iClazzManagerInfoService = iClazzManagerInfoService;
    }
    @Operation(summary = "获取班级信息详细")
    @GetMapping
    public List<Clazz> queryClazzInfoById(@RequestParam List<Clazz> clazzes){
        return iClazzService.listByIds(clazzes);
    }
    @Operation(summary = "获取教师下管理的班级信息", description = "获取所有班级信息")
    @GetMapping("/teacher")
    public List<Clazz> getClazzManagedByStaff(@RequestParam String employeeId) {
        return iClazzManagerInfoService.getClazzManagedByStaff(employeeId);
    }

}
