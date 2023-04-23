package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.Grade;
import com.osmium.schoolconnect.backend.entity.pojo.GradeVO;
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
@RequestMapping("/grade")
@Tag(name  = "成绩专区")
public class GradeController {

    private final IGradeService iGradeService;

    public GradeController(IGradeService iGradeService) {
        this.iGradeService = iGradeService;
    }


    @Operation(summary = "查询该同学分数")
    @GetMapping("/by_id")
    public List<GradeVO> getGradeById(@RequestParam String userId,@RequestParam(required = false) String year, @RequestParam(required = false) String semester) {
        return iGradeService.listGradeByUserId(userId, year, semester);
    }

    @Operation(summary = "查询班级分数")
    @GetMapping("/by_class")
    public List<GradeVO> getGradeByClazz(@RequestParam String clazzId, @RequestParam String year, @RequestParam String semester) {
        return iGradeService.listGradeByClazz(clazzId, year, semester);
    }
    @Operation(summary = "导入成绩")
    @PostMapping
    public Boolean setGrade(@RequestBody List<Grade> newGrades) {
        return iGradeService.saveBatch(newGrades);
    }

    @Operation(summary = "修改成绩")

    @PutMapping
    public Boolean updateGrade(@RequestBody List<Grade> grades) {
        return iGradeService.updateBatchById(grades);
    }
    @Operation(summary = "删除成绩")

    @DeleteMapping
    public Boolean deleteGrade(@RequestBody List<Grade> gradeId) {
        return iGradeService.removeBatchByIds(gradeId);
    }
}
