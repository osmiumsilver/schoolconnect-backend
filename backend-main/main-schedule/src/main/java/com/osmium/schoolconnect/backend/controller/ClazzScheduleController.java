package com.osmium.schoolconnect.backend.controller;

import cn.hutool.json.JSONUtil;
import com.osmium.schoolconnect.backend.entity.ClazzSchedule;
import com.osmium.schoolconnect.backend.entity.pojo.ClazzScheduleVO;
import com.osmium.schoolconnect.backend.service.IClazzScheduleService;
import com.osmium.schoolconnect.backend.utils.annotations.AdministrativeAccess;
import com.osmium.schoolconnect.backend.utils.annotations.TeacherOnlyAccess;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author abel
 * @Date 2023/2/19
 * @Description 课表控制器
 */
@RestController
@RequestMapping("/schedule")
public class ClazzScheduleController {

    private final IClazzScheduleService iClazzScheduleService;

    public ClazzScheduleController(IClazzScheduleService iClazzScheduleService) {
        this.iClazzScheduleService = iClazzScheduleService;
    }


    @Operation(summary = "根据班级ID查询课表")
    @GetMapping("/class")
    public List<ClazzScheduleVO> getClazzScheduleByClazz(@RequestParam String classNo, @RequestParam String year, @RequestParam String semester) {
        var clazzSchedules = iClazzScheduleService.listClazzScheduleByClazz(classNo, year, semester);
        for (ClazzSchedule clazzSchedule : clazzSchedules) {

            clazzSchedule.setWeeks(JSONUtil.parseArray(clazzSchedule.getWeeks()));

        }
        return clazzSchedules;
    }
    @Operation(summary = "查询教师课表")
    @TeacherOnlyAccess
    @GetMapping("/teacher")
    public List<ClazzScheduleVO> getClazzScheduleByTeacher(@RequestParam String userId, @RequestParam String year, @RequestParam String semester) {
        var clazzSchedules = iClazzScheduleService.listScheduleByTeacher(userId, year, semester);
        for (ClazzSchedule clazzSchedule : clazzSchedules) {

            clazzSchedule.setWeeks(JSONUtil.parseArray(clazzSchedule.getWeeks()));

        }
        return clazzSchedules;
    }

    @Operation(summary = "添加课表安排")
    @AdministrativeAccess
    @PostMapping("/class")
    public Boolean addToClazzSchedule(@RequestBody ClazzSchedule clazzSchedule) {


            clazzSchedule.setWeeks(JSONUtil.toJsonPrettyStr(clazzSchedule.getWeeks()));


        return iClazzScheduleService.save(clazzSchedule);

    }

    @Operation(summary = "修改课表安排")
    @AdministrativeAccess
    @PutMapping("/class")
    public Boolean modifyClazzSchedule(@RequestBody ClazzSchedule clazzSchedule) {
        return iClazzScheduleService.updateById(clazzSchedule);

    }

    @Operation(summary = "删除课表安排")
    @AdministrativeAccess
    @DeleteMapping("/class")
    public Boolean deleteClazzSchedule(@RequestBody ClazzSchedule clazzSchedule) {
        return iClazzScheduleService.removeById(clazzSchedule);
    }
}
