package com.osmium.schoolconnect.backend.controller;

import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.osmium.schoolconnect.backend.controller.basic.ClazzController;
import com.osmium.schoolconnect.backend.entity.Grade;
import com.osmium.schoolconnect.backend.entity.pojo.GradeRevisionDTO;
import com.osmium.schoolconnect.backend.entity.pojo.GradeVO;
import com.osmium.schoolconnect.backend.service.IGradeService;
import com.osmium.schoolconnect.backend.utils.ExcelUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author
 * @Date 2023/2/15
 * @Description
 */
@RestController
@PreAuthorize("hasAnyAuthority('[SUPER]','[ADMINISTRATIVE]','[TEACHER]')")
@RequestMapping("/grade")
@Tag(name = "成绩控制器")
public class GradeController {
    private final ClazzController clazzController;
    private final IGradeService iGradeService;

    public GradeController(ClazzController clazzController, IGradeService iGradeService) {
        this.clazzController = clazzController;
        this.iGradeService = iGradeService;
    }


    @Operation(summary = "查询该同学分数")
    @GetMapping("/by_id")
    public List<GradeVO> getGradeById(@RequestParam String userId, @RequestParam(required = false) String year, @RequestParam(required = false) String semester) {
        return iGradeService.listGradeByUserId(userId, year, semester);
    }

    @Operation(summary = "查询班级分数")
    @GetMapping("/by_class")
    public List<GradeVO> getGradeByClazz(@RequestParam String courseId, @RequestParam String clazzId, @RequestParam String year, @RequestParam String semester) {
        return iGradeService.listGradeByClazz(courseId, clazzId, year, semester);
    }

    @Operation(summary = "导入成绩")
    @PostMapping
    public Boolean setGrade(@RequestBody List<Grade> newGrades) {
        return iGradeService.saveBatch(newGrades);
    }

    @Operation(summary = "Excel导入成绩")
    @PostMapping("/import")
    public Boolean importGrade(@RequestPart MultipartFile file) throws IOException {
        List<Grade> gradeList = ExcelUtils.importExcel(file, 1, 1, Grade.class);
        return iGradeService.saveBatch(gradeList);
    }

    @Operation(summary = "Excel导出模版")
    @PostMapping("/export")
    public void exportGradeTemplate(@RequestParam String clazzId, String courseId, Integer year, Integer semester, HttpServletResponse response) throws IOException {
        var roster = clazzController.queryStudentUnderClass(clazzId);
        TemplateExportParams params = new TemplateExportParams(
                "doc/成绩模版.xls");
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> listMap = new ArrayList<>();
        for (HashMap<String, String> stringStringHashMap : roster) {
            Map<String, Object> lm = new HashMap<>();
            lm.put("id", stringStringHashMap.get("employee_id"));
            lm.put("name", stringStringHashMap.get("name"));
            lm.put("class_no", clazzId);
            lm.put("course_no", courseId);
            lm.put("year", year);
            lm.put("semester", semester);

            listMap.add(lm);
        }
        map.put("maplist", listMap);
        ExcelUtils.exportExcel(params, map, "grade", response);
    }


    @Operation(summary = "修改成绩并等待审核")
    @PatchMapping
    public Boolean updateGradeAndRevision(@RequestBody GradeRevisionDTO grade) {
        return iGradeService.updateGradeAndRevision(grade);
    }

    @Operation(summary = "删除成绩")

    @DeleteMapping
    public Boolean deleteGrade(@RequestBody List<Grade> gradeId) {
        return iGradeService.removeBatchByIds(gradeId);
    }
}
