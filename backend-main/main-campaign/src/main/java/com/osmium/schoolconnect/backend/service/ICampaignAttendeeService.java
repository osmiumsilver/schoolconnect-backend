package com.osmium.schoolconnect.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.osmium.schoolconnect.backend.entity.CampaignAttendee;
import com.osmium.schoolconnect.backend.entity.pojo.CampaignAttendeeVO;
import com.osmium.schoolconnect.backend.entity.pojo.CampaignStatusDTO;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/28
 * @Description
 */
public interface ICampaignAttendeeService extends IService<CampaignAttendee> {
    List<String> listCampaignsIAttended(String userId, String status);

    List<CampaignAttendeeVO> listAttendees(String campaignId);

    CampaignStatusDTO getUserStatusOfCampaign(String userId, String campaignId);

    Boolean updateOne(String attendantsId, int i);
}
