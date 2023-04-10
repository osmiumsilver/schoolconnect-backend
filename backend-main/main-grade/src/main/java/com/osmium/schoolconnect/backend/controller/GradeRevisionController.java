package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.Grade;
import com.osmium.schoolconnect.backend.entity.pojo.GradeVO;
import com.osmium.schoolconnect.backend.service.IGradeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * @Date 2023/3/6
 * @Description
 */
@RestController

@RequestMapping("/grade/review")
@Tag(name="成绩审核")
public class GradeRevisionController {
    private final IGradeService iGradeService;

    public GradeRevisionController(IGradeService iGradeService) {
        this.iGradeService = iGradeService;
    }

    @Operation(summary = "查询需要审核的成绩")
    @GetMapping
    public List<Grade> listGradeWaitingForRevision(@RequestParam String userId) {
        return iGradeService.listGradeWaitingForRevision(userId);
    }

}
