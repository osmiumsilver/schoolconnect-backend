package com.osmium.schoolconnect.backend.controller;

import cn.hutool.json.JSONObject;
import com.osmium.schoolconnect.backend.entity.DepartmentInfo;
import com.osmium.schoolconnect.backend.misc.Result;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import com.osmium.schoolconnect.backend.service.IDepartmentInfoService;
import com.osmium.schoolconnect.backend.service.IDepartmentManagerInfoService;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping
    public Boolean addDepartments(@RequestBody List<DepartmentInfo> departments) {
        return iDepartmentInfoService.saveBatch(departments);
    }

    @PutMapping
    public Boolean updateDepartments(@RequestBody List<DepartmentInfo> departments) {
        return iDepartmentInfoService.updateBatchById(departments);
    }

    @DeleteMapping
    public Boolean deleteDepartments(@RequestBody List<DepartmentInfo> departments) {
      return iDepartmentInfoService.removeBatchByIds(departments);
    }

}
