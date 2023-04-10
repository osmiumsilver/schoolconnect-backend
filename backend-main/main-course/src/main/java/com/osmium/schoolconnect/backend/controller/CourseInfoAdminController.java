package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.Course;
import com.osmium.schoolconnect.backend.service.ICourseService;
import com.osmium.schoolconnect.backend.utils.annotations.SuperAccess;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/19
 * @Description
 */
@RestController
@RequestMapping("/admin/course")
@Tag(name = "课程信息管理员")
public class CourseInfoAdminController {
    private final ICourseService iCourseService;

    public CourseInfoAdminController(ICourseService iCourseService) {
        this.iCourseService = iCourseService;
    }

    @Operation(summary = "获取所有课程信息")
    @GetMapping("/")
    public List<Course> getAllCourses() {
        return iCourseService.list();
    }

    @Operation(summary = "根据课程号批量获取课程信息")

    @GetMapping
    public List<Course> getCourseById(@RequestParam List<String> courseId) {
        return iCourseService.listByIds(courseId);
    }

    @Operation(summary = "批量添加课程信息")
    @SuperAccess
    @PostMapping
    public Boolean addCoursesInfo(@RequestBody List<Course> courses) {
        return iCourseService.saveBatch(courses);
    }

    @Operation(summary = "批量修改课程信息")

    @SuperAccess
    @PutMapping
    public Boolean updateCoursesInfo(@RequestBody List<Course> courses) {
        return iCourseService.updateBatchById(courses);
    }

    @Operation(summary = "批量删除课程")
    @SuperAccess
    @DeleteMapping
    public Boolean deleteCoursesInfo(@RequestBody List<Course> courses) {
        return iCourseService.removeBatchByIds(courses);

    }


}
