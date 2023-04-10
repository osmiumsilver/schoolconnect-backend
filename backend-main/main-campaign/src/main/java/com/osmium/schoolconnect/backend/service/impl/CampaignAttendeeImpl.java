package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.CampaignAttendee;
import com.osmium.schoolconnect.backend.mapper.CampaignAttendeeMapper;
import com.osmium.schoolconnect.backend.service.ICampaignAttendeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/28
 * @Description
 */
@Validated
@Repository
@RequiredArgsConstructor
public class CampaignAttendeeImpl extends ServiceImpl<CampaignAttendeeMapper, CampaignAttendee> implements ICampaignAttendeeService {
    @Override
    public List<String> listCampaignsIAttended(String userId,String status) {
        return baseMapper.listCampaignsById(userId,status);
    }

    @Override
    public String getAttendantId(Authentication authentication, String campaignId, String attendantId) {
        return null;
    }

    @Override
    public Boolean amIAttended(Authentication authentication, String campaignId) {
        QueryWrapper q = new QueryWrapper();
        q.eq("campaign_id",campaignId);
        q.eq("attendee_id",authentication.getName());
       return baseMapper.exists(q);
    }

    @Override
    public Boolean amICheckedIn(Authentication authentication, String campaignId) {
        QueryWrapper q = new QueryWrapper();
        q.eq("campaign_id",campaignId);
        q.eq("attendee_id",authentication.getName());
        q.eq("check_in_status",1);
        return baseMapper.exists(q);
    }


    @Override
    public List<CampaignAttendee> listAttendees(String campaignId) {
     return baseMapper.listAttendees(campaignId);
    }
}
