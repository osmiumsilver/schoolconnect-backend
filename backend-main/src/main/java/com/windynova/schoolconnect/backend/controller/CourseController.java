package com.osmium.schoolconnect.backend.controller;

import cn.hutool.json.JSONObject;
import com.osmium.schoolconnect.backend.entity.Course;
import com.osmium.schoolconnect.backend.entity.DepartmentInfo;
import com.osmium.schoolconnect.backend.misc.Result;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import com.osmium.schoolconnect.backend.service.ICourseService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/19
 * @Description
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    private final ICourseService iCourseService;

    public CourseController(ICourseService iCourseService) {
        this.iCourseService = iCourseService;
    }

    @GetMapping
    public Result<List<Course>> getAllCourses() {
        return Result.success(iCourseService.list());
    }


    @PostMapping
    public Result<JSONObject> addCourses(@RequestBody List<Course> courses) {
        if (iCourseService.saveBatch(courses))
            return Result.success();
        else return Result.error(ResultCode.TODO);
    }

    @PutMapping
    public Result<JSONObject> updateCourses(@RequestBody List<Course> courses) {
        if (iCourseService.updateBatchById(courses))
            return Result.success();
        else return Result.error(ResultCode.TODO);
    }

    @DeleteMapping
    public Result<JSONObject> deleteCourses(@RequestBody List<Course> courses) {
        if (iCourseService.removeBatchByIds(courses))
            return Result.success();
        else return Result.error(ResultCode.TODO);
    }
}
