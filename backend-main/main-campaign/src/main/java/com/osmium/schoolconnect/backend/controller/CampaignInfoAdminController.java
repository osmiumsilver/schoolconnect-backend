package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.CampaignInfo;
import com.osmium.schoolconnect.backend.entity.pojo.CampaignInfoVO;
import com.osmium.schoolconnect.backend.service.ICampaignInfoService;
import com.osmium.schoolconnect.backend.utils.annotations.SuperAccess;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * @Date 2023/3/6
 * @Description
 */
@RestController
@RequestMapping("/admin/campaign")
@SuperAccess
@Tag(name = "活动专区管理员")
public class CampaignInfoAdminController {
    private final ICampaignInfoService iCampaignInfoService;

    public CampaignInfoAdminController(ICampaignInfoService iCampaignInfoService) {
        this.iCampaignInfoService = iCampaignInfoService;

    }

    @PreAuthorize(value = "authentication.name.equals(#campaignLauncher)")
    @Operation(summary = "根据工号查询发起者发起过的所有Campaign")
    @GetMapping
    public List<CampaignInfoVO> listCampaignsByLauncher(@RequestParam String campaignLauncher) {
        return iCampaignInfoService.listCampaignsByLauncher(campaignLauncher);
    }

    @Operation(summary = "获取所有活动信息")
    @GetMapping("/")
    public List<CampaignInfo> getAllCampaigns() {
        return iCampaignInfoService.list();
    }


    @Operation(summary = "批量添加活动信息")
    @PostMapping
    public Boolean addCampaigns(@RequestBody List<CampaignInfo> newCampaigns) {
        return iCampaignInfoService.saveBatch(newCampaigns);
    }

    @Operation(summary = "批量修改活动信息")
    @PutMapping
    public Boolean updateCampaigns(@RequestBody List<CampaignInfo> campaignInfos) {
        return iCampaignInfoService.updateBatchById(campaignInfos);
    }

    @Operation(summary = "批量删除活动信息")
    @DeleteMapping
    public Boolean deleteCampaigns(@RequestBody List<CampaignInfo> campaignInfos) {
        return iCampaignInfoService.removeBatchByIds(campaignInfos);
    }
}
