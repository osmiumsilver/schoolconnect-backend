package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.pojo.GradeVO;
import com.osmium.schoolconnect.backend.service.IGradeService;
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
 * @Date 2023/3/5
 * @Description
 */
@RestController
@RequestMapping("/grade")
@Tag(name = "学生成绩控制器")
public class GradeControllerForStudent {
    private final IGradeService iGradeService;

    public GradeControllerForStudent(IGradeService iGradeService) {
        this.iGradeService = iGradeService;
    }

    @Operation(summary = "学生根据学号查询自己成绩")
    @GetMapping("/get_my_grade")
    public List<GradeVO> getGradeById(Authentication authentication, @RequestParam(required = false) String year, @RequestParam(required = false) String semester) {
        return iGradeService.listGradeByUserId(authentication.getName(), year, semester);
    }
}
