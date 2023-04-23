package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.DepartmentManagerInfo;
import com.osmium.schoolconnect.backend.service.IDepartmentManagerInfoService;
import com.osmium.schoolconnect.backend.utils.annotations.SuperAccess;
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
@SuperAccess
@RequestMapping("/admin/department/manager")
public class DepartmentManagerAdminController {

    private final IDepartmentManagerInfoService iDepartmentManagerInfoService;

    public DepartmentManagerAdminController(IDepartmentManagerInfoService iDepartmentManagerInfoService) {
        this.iDepartmentManagerInfoService = iDepartmentManagerInfoService;
    }


    @GetMapping
    public List<DepartmentManagerInfo> getManagersByDepartment(@RequestParam List<DepartmentManagerInfo> managerId) {
        return iDepartmentManagerInfoService.getManagersByDepartment(managerId);
    }

    @PostMapping
    public Boolean addDepartmentManagers(@RequestBody List<DepartmentManagerInfo> departments) {
        return iDepartmentManagerInfoService.saveBatch(departments);

    }

    @DeleteMapping
    public Boolean deleteDepartmentManagers(@RequestBody List<DepartmentManagerInfo> departments) {
        return iDepartmentManagerInfoService.removeBatchByIds(departments);
    }

    @PutMapping
    public Boolean updateDepartmentManagers(@RequestBody List<DepartmentManagerInfo> departments) {
       return iDepartmentManagerInfoService.updateBatchById(departments);
    }


}
