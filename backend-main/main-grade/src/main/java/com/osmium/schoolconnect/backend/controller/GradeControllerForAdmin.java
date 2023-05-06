package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.Grade;
import com.osmium.schoolconnect.backend.service.IGradeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/15
 * @Description
 */
@RestController
@PreAuthorize("hasAnyAuthority('[SUPER]','[ADMINISTRATIVE]','[TEACHER]')")
@RequestMapping("/admin/grade")
@Tag(name  = "成绩控制器")
public class GradeControllerForAdmin {

    private final IGradeService iGradeService;

    public GradeControllerForAdmin(IGradeService iGradeService) {
        this.iGradeService = iGradeService;
    }


    @Operation(summary = "修改成绩")
    @PatchMapping
    public Boolean updateGrade(@RequestBody List<Grade> grades) {
        return iGradeService.updateBatchById(grades);
    }

}
