package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.Clazz;
import com.osmium.schoolconnect.backend.entity.pojo.ClazzDetailsVO;
import com.osmium.schoolconnect.backend.service.IClazzManagerInfoService;
import com.osmium.schoolconnect.backend.service.IClazzService;
import com.osmium.schoolconnect.backend.utils.annotations.SuperAccess;
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
@SuperAccess
@RequestMapping("/class/detail")
public class ClazzInfoController {
    private final IClazzService iClazzService;
    private final IClazzManagerInfoService iClazzManagerInfoService;

    public ClazzInfoController(IClazzService iClazzService, IClazzManagerInfoService iClazzManagerInfoService) {
        this.iClazzService = iClazzService;
        this.iClazzManagerInfoService = iClazzManagerInfoService;
    }

    @Operation(summary = "获取班级信息详细+负责人")
    @GetMapping
    public List<ClazzDetailsVO> listClazzDetailsById(@RequestParam List<Clazz> clazzes) {
        return iClazzService.listClazzDetailsById(clazzes);
    }

    @Operation(summary = "获取负责人管理了哪些班级")
    @GetMapping("/managed_by_teacher")
    public List<Clazz> getClazzManagedByStaff(@RequestParam String employeeId) {
        return iClazzManagerInfoService.getClazzManagedByStaff(employeeId);
    }

}
