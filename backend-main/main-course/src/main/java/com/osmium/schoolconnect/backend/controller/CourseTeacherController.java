package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.service.ICourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "教师课程控制器")
@RestController
@RequestMapping("/teacher")
public class CourseTeacherController {
    private final ICourseService iCourseService;

    public CourseTeacherController(ICourseService iCourseService) {
        this.iCourseService = iCourseService;
    }

    @Operation(summary = "根据TOKEN查询教师所教班级")
    @GetMapping("/class")
    public List<String> listClazzesTaughtByTeacher(Authentication authentication)
    {
        return iCourseService.listClazzesTaughtByTeacher(authentication.getName());
    }
}
