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

    //@GetMapping
    //public List<CourseInfo> getAllCoursesInfo() {
    //    return iCourseInfoService.list();
    //}

    @GetMapping
    public List<CourseInfo> getCoursesByTeacher(@RequestParam String userId)
    {
        return iCourseInfoService.getCoursesByTeacher(userId);
    }

    @PostMapping
    public Boolean addCoursesInfo(@RequestBody List<CourseInfo> courses) {
       return iCourseInfoService.saveBatch(courses);
    }

    @PutMapping
    public Boolean updateCoursesInfo(@RequestBody List<CourseInfo> courses) {
       return iCourseInfoService.updateBatchById(courses);
    }

    @DeleteMapping
    public Boolean deleteCoursesInfo(@RequestBody List<CourseInfo> courses) {
        return iCourseInfoService.removeBatchByIds(courses);

    }
}
