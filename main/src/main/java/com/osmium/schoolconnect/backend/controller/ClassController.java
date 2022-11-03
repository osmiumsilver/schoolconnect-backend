package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.Clazz;
import com.osmium.schoolconnect.backend.service.ClazzService;
import com.osmium.schoolconnect.backend.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;



/**
 * @author
 * @date 2022/3/30
 * @apinote
 */

@RestController
@RequestMapping("/api/class")
public class ClassController {

    @Autowired
    private ClazzService classService;

    @ApiOperation(value = "添加班级", notes = "传入班级信息")
    @PostMapping(value = "/addclass")
    public Result addClass(@RequestBody List<Clazz> list)throws Exception {
        for (Clazz clazz : list) {
            classService.insertClass(clazz);
        }
        return new Result(classService.selectClassList((Clazz) list));
    }

}
