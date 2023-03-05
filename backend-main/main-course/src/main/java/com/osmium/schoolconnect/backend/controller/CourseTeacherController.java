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
    public List<CourseAttendee> getAllCourses() {
        return iCourseService.list();
    }


    @PostMapping
    public Boolean addCourses(@RequestBody List<CourseAttendee> courses) {
       return  (iCourseService.saveBatch(courses));
    }

    @PutMapping
    public Boolean updateCourses(@RequestBody List<CourseAttendee> courses) {
      return iCourseService.updateBatchById(courses);
    }

    @DeleteMapping
    public Boolean deleteCourses(@RequestBody List<CourseAttendee> courses) {
        return iCourseService.removeBatchByIds(courses);
    }
}
