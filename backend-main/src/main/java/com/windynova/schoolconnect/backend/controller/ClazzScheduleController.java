package com.osmium.schoolconnect.backend.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.osmium.schoolconnect.backend.entity.ClazzSchedule;
import com.osmium.schoolconnect.backend.misc.Result;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import com.osmium.schoolconnect.backend.service.IClazzScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @Author abel
 * @Date 2023/2/19
 * @Description 课表控制器
 */
@RestController
@RequestMapping("/class/schedule")
public class ClazzScheduleController {

    private final IClazzScheduleService  iClazzScheduleService;
    public ClazzScheduleController(IClazzScheduleService iClazzScheduleService) {
        this.iClazzScheduleService = iClazzScheduleService;
    }



    @GetMapping
    public Result<List<ClazzSchedule>> getClazzScheduleByClazz(@RequestParam String classNo, @RequestParam String year, @RequestParam String semester)
    {
        return Result.success(iClazzScheduleService.listClazzScheduleByClazz(classNo, year, semester));
    }

    @PostMapping
    public Result<JSONObject> addToClazzSchedule(@RequestBody  List<ClazzSchedule> clazzSchedule)
    {
        if(iClazzScheduleService.saveBatch(clazzSchedule))
            return Result.success();
        else return Result.error(ResultCode.DATA_MANIPULATION_ERROR);
    }
    @PutMapping
    public Result<JSONObject> modifyClazzSchedule(@RequestBody  List<ClazzSchedule> clazzSchedule)
    {
        if(iClazzScheduleService.updateBatchById(clazzSchedule))
            return Result.success();
        else return Result.error(ResultCode.DATA_MANIPULATION_ERROR);
    }
    @DeleteMapping
    public Result<JSONObject> deleteClazzSchedule(@RequestBody  List<ClazzSchedule> clazzSchedule)
    {
        if(iClazzScheduleService.removeBatchByIds(clazzSchedule))
            return Result.success();
        else return Result.error(ResultCode.DATA_MANIPULATION_ERROR);
    }
}
