package com.osmium.schoolconnect.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.osmium.schoolconnect.backend.entity.CampaignInfo;

import java.io.Serializable;
import java.util.List;

/**
 * @Author
 * @Date 2023/2/28
 * @Description
 */
public interface ICampaignInfoService extends IService<CampaignInfo> {
    List<CampaignInfo> listCampaignsByLauncher(String campaignLauncher);
List<CampaignInfo> searchByName(String name);
    List<CampaignInfo> getOngoingCampaigns(String status);

    List<CampaignInfo> listCampaignsUserSignedUpFor(String user,String campaignStatus);

}
