package com.osmium.schoolconnect.backend.controller;

import cn.hutool.json.JSONObject;
import com.osmium.schoolconnect.backend.entity.Grade;
import com.osmium.schoolconnect.backend.entity.vo.GradeVO;
import com.osmium.schoolconnect.backend.misc.Result;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import com.osmium.schoolconnect.backend.service.IGradeService;
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

    @GetMapping
    public Result<List<GradeVO>> getGrade(@RequestParam String userId, @RequestParam(required = false) String year, @RequestParam(required = false) String semester) {
        return Result.success(iGradeService.findGradeByUserId(userId, year, semester));
    }

    @PostMapping
    public Result<JSONObject> setGrade(@RequestBody List<Grade> grade) {
        if (iGradeService.saveBatch(grade)) {
            return Result.success();
        }
        return Result.error(ResultCode.GRADE_ADD_ERROR);
    }

    @PutMapping
    public Result<JSONObject> updateGrade(@RequestBody List<Grade> grade) {
        if (iGradeService.updateBatchById(grade)) {
            return Result.success();
        }
        return Result.error(ResultCode.GRADE_MODIFY_ERROR);
    }

    @DeleteMapping
    public Result<JSONObject> deleteGrade(@RequestBody List<Grade> gradeId) {
        if (iGradeService.removeBatchByIds(gradeId)) {
            return Result.success();
        }
        return Result.error(ResultCode.GRADE_MODIFY_ERROR);
    }
}
