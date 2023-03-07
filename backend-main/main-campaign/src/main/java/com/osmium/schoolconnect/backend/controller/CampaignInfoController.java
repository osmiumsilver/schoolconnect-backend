package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.CampaignInfo;
import com.osmium.schoolconnect.backend.misc.APIException;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import com.osmium.schoolconnect.backend.service.ICampaignInfoService;
import com.osmium.schoolconnect.backend.utils.SecurityUtils;
import com.osmium.schoolconnect.backend.utils.annotations.CurrentUser;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/28
 * @Description
 */
@RestController
@RequestMapping("/campaign")
public class CampaignInfoController {
    private final ICampaignInfoService iCampaignInfoService;

    public CampaignInfoController(ICampaignInfoService iCampaignInfoService) {
        this.iCampaignInfoService = iCampaignInfoService;

    }
    @Operation(summary = "查询我发起的活动")
    @GetMapping("/my")
    public List<CampaignInfo> getMessagesSendByMe(Authentication authentication) {
        return iCampaignInfoService.listCampaignsByLauncher(authentication.getName());
    }

    @Operation(summary = "查询有效的活动")
    @GetMapping("/")
    public List<CampaignInfo> getAllOngoingCampaigns() {
        return iCampaignInfoService.getOngoingCampaigns();
    }

    @Operation(summary = "用户添加活动")
    @PostMapping
    public Boolean addMyCampaign(@RequestBody CampaignInfo newCampaigns) {
        if (!(newCampaigns.getCampaignLauncher().equals(SecurityUtils.getUserId())))
            throw new APIException(ResultCode.AUTH_NO_PERMISSION);
        return iCampaignInfoService.save(newCampaigns);
    }

    @Operation(summary = "用户修改活动")
    @PutMapping
    public Boolean modifyMyCampaign(@RequestBody CampaignInfo newCampaigns) {
        if (!(newCampaigns.getCampaignLauncher().equals(SecurityUtils.getUserId())))
            throw new APIException(ResultCode.AUTH_NO_PERMISSION);
        return iCampaignInfoService.updateById(newCampaigns);
    }
    @Operation(summary = "用户删除活动")
    @DeleteMapping
    public Boolean deleteMyCampaign(@RequestBody CampaignInfo newCampaigns) {
        if (!(newCampaigns.getCampaignLauncher().equals(SecurityUtils.getUserId())))
            throw new APIException(ResultCode.AUTH_NO_PERMISSION);
        return iCampaignInfoService.removeById(newCampaigns);
    }

}



