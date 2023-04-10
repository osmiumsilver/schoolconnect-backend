package com.osmium.schoolconnect.backend.controller;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.service.ICourseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author
 * @Date 2023/3/15
 * @Description
 */
@RestController
@RequestMapping("/teacher")
public class CourseTeacherController {
    private ICourseService iCourseService;

    public CourseTeacherController(ICourseService iCourseService) {
        this.iCourseService = iCourseService;
    }

    @Operation(summary = "查询教师所教班级")
    @GetMapping("/course")
    public List<String> listClazzesTaughtByTeacher(Authentication authentication)
    {
        return iCourseService.listClazzesTaughtByTeacher(authentication.getName());
    }
}
