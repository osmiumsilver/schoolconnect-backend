package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.Clazz;
import com.osmium.schoolconnect.backend.service.IClazzService;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author
 * @date 2022/3/30
 * @apinote
 */

@RestController
@RequestMapping("/class")
public class ClazzController {
    private final IClazzService clazzService;
    public ClazzController(IClazzService clazzService){
        this.clazzService = clazzService;
    }


    @Operation(summary="获取所有班级信息",description="获取所有班级信息")
    @GetMapping(value="getclass")
    public List<Clazz> findAll(){
    return clazzService.list();
    }



    @Operation(summary = "添加班级", description = "传入班级信息")
    @PostMapping(value = "/addclass")
    public ResponseEntity<Clazz> addClass(@RequestBody Clazz clazz) {
        System.out.println(clazz.getClassName());
        clazzService.saveOrUpdate(clazz);
return ResponseEntity.ok(clazz);
      //  return new Result(clazzService.listByMap((Map<String, Object>) list));
    }




}

