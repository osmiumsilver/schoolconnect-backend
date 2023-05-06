package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.Course;
import com.osmium.schoolconnect.backend.service.ICourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author
 * @Date 2023/3/7
 * @Description
 */
@RestController
@RequestMapping("/course")
@Tag(name = "课程信息")
public class CourseInfoController {
    private final ICourseService iCourseService;

    public CourseInfoController(ICourseService iCourseService) {
        this.iCourseService = iCourseService;
    }

    @Operation(summary = "查询该教师所教课程")
    @GetMapping("/by_teacher")
    public List<String> listCoursesTaughtByTeacher(Authentication authentication) {
        return iCourseService.listCoursesTaughtByTeacher(authentication.getName());
    }

    @GetMapping("/get-name")
    public String getCourseName(String courseId){
        return iCourseService.getName(courseId);
    }


    @Operation(summary = "根据课程号获取课程信息")

    @GetMapping("/by_course")
    public Course getCourseById(@RequestParam String courseId) {
        return iCourseService.getById(courseId);
    }
}
