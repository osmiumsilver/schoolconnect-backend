package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.ClazzSchedule;
import com.osmium.schoolconnect.backend.service.IClazzScheduleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/28
 * @Description
 */
@RestController
@RequestMapping("/schedule/teacher")

public class TeacherScheduleController {
    private final IClazzScheduleService iClazzScheduleService;

    public TeacherScheduleController(IClazzScheduleService iClazzScheduleService) {
        this.iClazzScheduleService = iClazzScheduleService;
    }


    @GetMapping
    public List<ClazzSchedule> getScheduleByTeacher(@RequestParam String userId, @RequestParam String year, @RequestParam String semester)
    {
        return iClazzScheduleService.listScheduleByTeacher(userId,year,semester);
    }
}
