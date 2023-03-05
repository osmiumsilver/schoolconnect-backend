package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.Clazz;
import com.osmium.schoolconnect.backend.service.IClazzService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Author Abel
 * @date 2022/3/30
 * @Description 班级控制器
 */

@RestController
@RequestMapping("/class/class")
public class ClazzController {
    private final IClazzService iClazzService;

    public ClazzController(IClazzService iClazzService) {
        this.iClazzService = iClazzService;
    }


    @Operation(summary = "获取所有班级信息")
    @GetMapping
    public List<Clazz> queryAllClazzes() {
        return iClazzService.list();
    }



    @Operation(summary = "添加班级")
    @PostMapping
    public Boolean addClazz(@RequestBody List<Clazz> clazzes) {
        return iClazzService.saveBatch(clazzes);

    }

    @Operation(summary = "修改班级")
    @PutMapping
    public Boolean updateCourses(@RequestBody List<Clazz> clazzes) {
        return iClazzService.updateBatchById(clazzes);
    }

    @Operation(summary = "删除班级")
    @DeleteMapping
    public Boolean deleteCourses(@RequestBody List<Clazz> clazzes) {
        return iClazzService.removeBatchByIds(clazzes);
    }
}

