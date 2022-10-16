package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.Clazz;
import com.osmium.schoolconnect.backend.service.ClazzService;
import com.osmium.schoolconnect.backend.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


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
    @RequestMapping(value = "/addclass", method = RequestMethod.POST)
    public Object addClass(@RequestParam("className") Clazz className){
        classService.insertClass(className);
        return null;
    }

}
