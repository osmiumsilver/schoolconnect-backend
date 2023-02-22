package com.osmium.schoolconnect.backend.controller;

import cn.hutool.json.JSONObject;
import com.osmium.schoolconnect.backend.entity.CourseInfo;
import com.osmium.schoolconnect.backend.misc.Result;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import com.osmium.schoolconnect.backend.service.ICourseInfoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/19
 * @Description
 */
@RestController
@RequestMapping("/course/detail")
public class CourseInfoController {
    private final ICourseInfoService iCourseInfoService;

    public CourseInfoController(ICourseInfoService iCourseInfoService) {
        this.iCourseInfoService = iCourseInfoService;
    }

    @GetMapping
    public Result<List<CourseInfo>> getAllCoursesInfo() {
        return Result.success(iCourseInfoService.list());
    }


    @PostMapping
    public Result<JSONObject> addCoursesInfo(@RequestBody List<CourseInfo> courses) {
        if (iCourseInfoService.saveBatch(courses))
            return Result.success();
        else return Result.error(ResultCode.DATA_MANIPULATION_ERROR);
    }

    @PutMapping
    public Result<JSONObject> updateCoursesInfo(@RequestBody List<CourseInfo> courses) {
        if (iCourseInfoService.updateBatchById(courses))
            return Result.success();
        else return Result.error(ResultCode.DATA_MANIPULATION_ERROR);
    }

    @DeleteMapping
    public Result<JSONObject> deleteCoursesInfo(@RequestBody List<CourseInfo> courses) {
        if (iCourseInfoService.removeBatchByIds(courses))
            return Result.success();
        else return Result.error(ResultCode.DATA_MANIPULATION_ERROR);
    }
}
