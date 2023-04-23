package com.osmium.schoolconnect.backend.controller.basic;

import com.osmium.schoolconnect.backend.entity.DepartmentInfo;
import com.osmium.schoolconnect.backend.service.IDepartmentInfoService;
import com.osmium.schoolconnect.backend.service.IDepartmentManagerInfoService;
import com.osmium.schoolconnect.backend.utils.annotations.SuperAccess;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/20
 * @Description
 */
@RestController
@SuperAccess
@RequestMapping("/department")
public class DepartmentController {
    private final IDepartmentInfoService iDepartmentInfoService;
    private final IDepartmentManagerInfoService iDepartmentManagerInfoService;


    public DepartmentController(IDepartmentInfoService iDepartmentInfoService, IDepartmentManagerInfoService iDepartmentManagerInfoService) {
        this.iDepartmentInfoService = iDepartmentInfoService;
        this.iDepartmentManagerInfoService = iDepartmentManagerInfoService;
    }
    @Operation(summary = "获取部门信息")

    @GetMapping
    public List<DepartmentInfo> getAllDepartments() {
        return iDepartmentInfoService.list();
    }

    @Operation(summary = "添加部门")

    @PostMapping
    public Boolean addDepartments(@RequestBody List<DepartmentInfo> departments) {
        return iDepartmentInfoService.saveBatch(departments);
    }
    @Operation(summary = "修改部门")

    @PutMapping
    public Boolean updateDepartments(@RequestBody List<DepartmentInfo> departments) {
        return iDepartmentInfoService.updateBatchById(departments);
    }
    @Operation(summary = "删除部门")

    @DeleteMapping
    public Boolean deleteDepartments(@RequestBody List<DepartmentInfo> departments) {
        return iDepartmentInfoService.removeBatchByIds(departments);
    }

}