package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.pojo.GradeDTO;
import com.osmium.schoolconnect.backend.entity.pojo.GradeVO;
import com.osmium.schoolconnect.backend.service.IGradeRevisionService;
import com.osmium.schoolconnect.backend.service.IGradeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * @Date 2023/3/6
 * @Description
 */
@RestController

@RequestMapping("/grade/review")
@Tag(name="成绩审核控制器")
public class GradeRevisionController {
    private final IGradeService iGradeService;
private final IGradeRevisionService iGradeRevisionService;
    public GradeRevisionController(IGradeService iGradeService, IGradeRevisionService iGradeRevisionService) {
        this.iGradeService = iGradeService;
        this.iGradeRevisionService = iGradeRevisionService;
    }

    @Operation(summary = "查询需要审核的成绩")
    @GetMapping
    public List<GradeVO> listGradeWaitingForRevision(@RequestParam String userId) {
        return iGradeService.listGradeWaitingForRevision(userId);
    }
    @Operation(summary = "审核成绩")
@PatchMapping
    public Boolean reviewGrade(@RequestBody List<GradeDTO> gradeDTO) {
        return iGradeRevisionService.updateBatchById(gradeDTO);
    }
}
