package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.Grade;
import com.osmium.schoolconnect.backend.entity.vo.GradeVO;
import com.osmium.schoolconnect.backend.service.IGradeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/15
 * @Description
 */
@RestController
@RequestMapping("/grade")
public class GradeController {

    private final IGradeService iGradeService;

    public GradeController(IGradeService iGradeService) {
        this.iGradeService = iGradeService;
    }
    @Operation(summary = "查询班级分数")
@GetMapping
    public List<GradeVO> getGradeByClazz(@RequestParam String clazzId, @RequestParam String year,@RequestParam String semester){
        return null;
    }
    @PreAuthorize("hasRole('SUPER') or hasRole('ROLE_ADMINISTRATIVE') or hasRole('TEACHER')")
    @PostMapping
    public Boolean setGrade(@RequestBody List<Grade> newGrades) {
        return iGradeService.saveBatch(newGrades);
    }

    @PutMapping
    public Boolean updateGrade(@RequestBody List<Grade> grades) {
        return iGradeService.updateBatchById(grades);
    }

    @DeleteMapping
    public Boolean deleteGrade(@RequestBody List<Grade> gradeId) {
        return iGradeService.removeBatchByIds(gradeId);
    }
}
