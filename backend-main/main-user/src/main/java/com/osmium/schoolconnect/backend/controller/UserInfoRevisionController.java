package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.User;
import com.osmium.schoolconnect.backend.entity.vo.UserInfoRevisionVO;
import com.osmium.schoolconnect.backend.service.IUserService;
import com.osmium.schoolconnect.backend.service.impl.UserInfoRevisionImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/11
 * @Description
 */
@RestController
@RequestMapping("/user/info/review")
@PreAuthorize("hasRole('ADMINISTRATIVE') or hasRole('SUPER')")

public class UserInfoRevisionController {
    private final IUserService iUserService;
    private final UserInfoRevisionImpl userInfoRevision;

    public UserInfoRevisionController(IUserService iUserService, UserInfoRevisionImpl userInfoRevision) {
        this.iUserService = iUserService;
        this.userInfoRevision = userInfoRevision;
    }
    @PreAuthorize("#userId == authentication.name")
    @Operation(summary = "获取该教务人员下管理的班级中需要审核信息（学籍等）的人员")
    @GetMapping
    public List<User> getWaitingForRevisionInfo(@RequestParam String userId) {
        return iUserService.getEmployeesWaitingToBeReviewedByManagerID(userId);
    }


    @Operation(summary = "确认审核完毕")
    @PutMapping
    public Boolean changingStatusOfRevision(@RequestBody List<UserInfoRevisionVO> usersToBeChangingStatus)
    {
        return userInfoRevision.updateBatchById(usersToBeChangingStatus);
    }

    }



