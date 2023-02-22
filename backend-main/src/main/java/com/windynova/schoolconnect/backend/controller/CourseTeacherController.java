package com.osmium.schoolconnect.backend.controller;

import cn.hutool.json.JSONObject;
import com.osmium.schoolconnect.backend.entity.CourseAttendee;
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
public class CourseTeacherController {
    private final ICourseService iCourseService;

    public CourseTeacherController(ICourseService iCourseService) {
        this.iCourseService = iCourseService;
    }

    @GetMapping
    public Result<List<CourseAttendee>> getAllCourses() {
        return Result.success(iCourseService.list());
    }


    @PostMapping
    public Result<JSONObject> addCourses(@RequestBody List<CourseAttendee> courses) {
        if (iCourseService.saveBatch(courses))
            return Result.success();
        else return Result.error(ResultCode.DATA_MANIPULATION_ERROR);
    }

    @PutMapping
    public Result<JSONObject> updateCourses(@RequestBody List<CourseAttendee> courses) {
        if (iCourseService.updateBatchById(courses))
            return Result.success();
        else return Result.error(ResultCode.DATA_MANIPULATION_ERROR);
    }

    @DeleteMapping
    public Result<JSONObject> deleteCourses(@RequestBody List<CourseAttendee> courses) {
        if (iCourseService.removeBatchByIds(courses))
            return Result.success();
        else return Result.error(ResultCode.DATA_MANIPULATION_ERROR);
    }
}
