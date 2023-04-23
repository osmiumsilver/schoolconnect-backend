package com.osmium.schoolconnect.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.osmium.schoolconnect.backend.entity.CampaignInfo;
import com.osmium.schoolconnect.backend.entity.pojo.CampaignInfoVO;

import java.io.Serializable;
import java.util.List;

/**
 * @Author
 * @Date 2023/2/28
 * @Description
 */
public interface ICampaignInfoService extends IService<CampaignInfo> {
    List<CampaignInfoVO> listCampaignsByLauncher(String campaignLauncher);
Byte getCampaignStatus(String campaignId);
    List<CampaignInfo> getCampaignByStatus(String status);


    CampaignInfoVO getById(Serializable id);

    List<CampaignInfo> listCampaignsUserSignedUpFor(String user, String campaignStatus);

    List<String> listPictures(String campaignId);
}
