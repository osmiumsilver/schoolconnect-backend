package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.Clazz;
import com.osmium.schoolconnect.backend.service.ClazzService;
import com.osmium.schoolconnect.backend.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;


/**
 * @author
 * @date 2022/3/30
 * @apinote
 */

@RestController
@RequestMapping("/class")
public class ClassController {
    private final ClazzService clazzService;
    public ClassController(ClazzService clazzService){
        this.clazzService = clazzService;
    }


    @ApiOperation(value = "添加班级", notes = "传入班级信息")
    @PostMapping(value = "/addclass")
    public ResponseEntity<Clazz> addClass(@RequestBody Clazz clazz) {
        System.out.println(clazz.getClassName());
        clazzService.saveOrUpdate(clazz);
return ResponseEntity.ok(clazz);
      //  return new Result(clazzService.listByMap((Map<String, Object>) list));
    }




}

