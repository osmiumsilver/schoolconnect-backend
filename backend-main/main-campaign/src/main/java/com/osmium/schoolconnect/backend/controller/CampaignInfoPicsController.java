package com.osmium.schoolconnect.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.osmium.schoolconnect.backend.entity.CampaignInfoPics;
import com.osmium.schoolconnect.backend.service.ICampaignInfoPicService;
import org.springframework.web.bind.annotation.*;

/**
 * @Author
 * @Date 2023/4/17
 * @Description
 */
@RestController
@RequestMapping("/campaign/info/pics")
public class CampaignInfoPicsController {
    private ICampaignInfoPicService iCampaignInfoPicService;

    public CampaignInfoPicsController(ICampaignInfoPicService iCampaignInfoPicService) {
        this.iCampaignInfoPicService = iCampaignInfoPicService;
    }

    @DeleteMapping
    public Boolean deletePics(@RequestParam String userId, @RequestBody CampaignInfoPics campaignInfoPics){
        QueryWrapper<CampaignInfoPics> query = new QueryWrapper();
        query.eq("picture_url",campaignInfoPics.getPictureUrl());
        return iCampaignInfoPicService.remove(query);
    }
}
