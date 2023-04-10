package com.osmium.schoolconnect.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.osmium.schoolconnect.backend.entity.CampaignAttendee;
import org.springframework.security.core.Authentication;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/28
 * @Description
 */
public interface ICampaignAttendeeService extends IService<CampaignAttendee> {
    List<String> listCampaignsIAttended(String userId,String status);

    Object amIAttended(Authentication authentication, String campaignId);

    List<CampaignAttendee> listAttendees(String campaignId);

    Boolean amICheckedIn(Authentication authentication, String campaignId);

    String getAttendantId(Authentication authentication, String campaignId, String attendantId);
}
