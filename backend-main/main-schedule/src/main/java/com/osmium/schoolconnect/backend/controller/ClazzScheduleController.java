package com.osmium.schoolconnect.backend.controller;

import cn.hutool.json.JSONUtil;
import com.osmium.schoolconnect.backend.entity.ClazzSchedule;
import com.osmium.schoolconnect.backend.service.IClazzScheduleService;
import com.osmium.schoolconnect.backend.utils.annotations.AdministrativeAccess;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author abel
 * @Date 2023/2/19
 * @Description 课表控制器
 */
@RestController
@RequestMapping("/schedule/class")
public class ClazzScheduleController {

    private final IClazzScheduleService iClazzScheduleService;

    public ClazzScheduleController(IClazzScheduleService iClazzScheduleService) {
        this.iClazzScheduleService = iClazzScheduleService;
    }


    @Operation(summary = "根据班级ID查询课表")
    @GetMapping
    public List<ClazzSchedule> getClazzScheduleByClazz(@RequestParam String classNo, @RequestParam String year, @RequestParam String semester) {
        var clazzSchedules = iClazzScheduleService.listClazzScheduleByClazz(classNo, year, semester);
        for (ClazzSchedule clazzSchedule : clazzSchedules) {

            clazzSchedule.setWeeks(JSONUtil.parseArray(clazzSchedule.getWeeks()));

        }
        return clazzSchedules;
    }

    @Operation(summary = "添加课表安排")
    @AdministrativeAccess
    @PostMapping
    public Boolean addToClazzSchedule(@RequestBody List<ClazzSchedule> clazzSchedule) {
        return iClazzScheduleService.saveBatch(clazzSchedule);

    }

    @Operation(summary = "修改课表安排")
    @AdministrativeAccess
    @PutMapping
    public Boolean modifyClazzSchedule(@RequestBody List<ClazzSchedule> clazzSchedule) {
        return iClazzScheduleService.updateBatchById(clazzSchedule);

    }

    @Operation(summary = "删除课表安排")
    @AdministrativeAccess
    @DeleteMapping
    public Boolean deleteClazzSchedule(@RequestBody List<ClazzSchedule> clazzSchedule) {
        return iClazzScheduleService.removeBatchByIds(clazzSchedule);
    }
}
