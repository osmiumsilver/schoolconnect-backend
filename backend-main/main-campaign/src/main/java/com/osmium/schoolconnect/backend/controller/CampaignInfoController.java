package com.osmium.schoolconnect.backend.controller;

import com.osmium.schoolconnect.backend.entity.CampaignInfo;
import com.osmium.schoolconnect.backend.service.ICampaignAttendeeService;
import com.osmium.schoolconnect.backend.service.ICampaignInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/28
 * @Description
 */
@RestController
@RequestMapping("/campaign/info")
public class CampaignInfoController {
private final ICampaignInfoService iCampaignInfoService;
    public CampaignInfoController(ICampaignInfoService iCampaignInfoService) {
        this.iCampaignInfoService = iCampaignInfoService;
    }

    @GetMapping
        public List<CampaignInfo> listCampaignsByLauncher(@RequestParam String campaignLauncher) {
            return iCampaignInfoService.listCampaignsByLauncher(campaignLauncher);
        }

        @GetMapping("/ongoing")
        public List<CampaignInfo> getAllOngoingCampaigns(){
        return iCampaignInfoService.getAllCampaigns();
        }
        @GetMapping("/")
        public List<CampaignInfo> getAllCampaigns(){
        return iCampaignInfoService.list();
        }

        @PostMapping
        public Boolean addCampaigns(@RequestBody List<CampaignInfo> newCampaigns) {
            return iCampaignInfoService.saveBatch(newCampaigns);
        }

        @PutMapping
        public Boolean updateCampaigns(@RequestBody List<CampaignInfo> campaignInfos) {
            return iCampaignInfoService.updateBatchById(campaignInfos);
        }

        @DeleteMapping
        public Boolean deleteCampaigns(@RequestBody List<CampaignInfo> campaignInfos) {
            return iCampaignInfoService.removeBatchByIds(campaignInfos);
        }
    }


