package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.User;
import com.osmium.schoolconnect.backend.entity.pojo.UserInfoRevisionVO;
import com.osmium.schoolconnect.backend.service.IUserService;
import com.osmium.schoolconnect.backend.service.UserInfoRevision;
import com.osmium.schoolconnect.backend.utils.annotations.AccessIsolation;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/11
 * @Description 教务员审核信息
 */
@RestController
@RequestMapping("/user/info/review")
@PreAuthorize("hasRole('ADMINISTRATIVE') or hasRole('SUPER')")
public class UserInfoRevisionController {
    private final IUserService iUserService;
    private final UserInfoRevision userInfoRevision;

    public UserInfoRevisionController(IUserService iUserService, UserInfoRevision userInfoRevision) {
        this.iUserService = iUserService;
        this.userInfoRevision = userInfoRevision;
    }

    @AccessIsolation
    @Operation(summary = "获取该教务人员下管理的班级中需要审核信息（学籍等）的人员")
    @GetMapping
    public List<User> getWaitingForRevisionInfo(@RequestParam String userId) {
        return iUserService.getEmployeesWaitingToBeReviewedByManagerID(userId);
    }


    @Operation(summary = "确认审核或者退回")
    @PutMapping
    public Boolean changingStatusOfRevision(@RequestBody List<UserInfoRevisionVO> usersAreBeingChanged) {
        return userInfoRevision.updateBatchById(usersAreBeingChanged);
    }

}



