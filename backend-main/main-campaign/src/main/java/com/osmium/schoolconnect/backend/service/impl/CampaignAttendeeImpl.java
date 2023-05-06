package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.CampaignAttendee;
import com.osmium.schoolconnect.backend.entity.pojo.CampaignAttendeeVO;
import com.osmium.schoolconnect.backend.entity.pojo.CampaignStatusDTO;
import com.osmium.schoolconnect.backend.mapper.CampaignAttendeeMapper;
import com.osmium.schoolconnect.backend.mapper.CampaignAttendeeVOMapper;
import com.osmium.schoolconnect.backend.service.ICampaignAttendeeService;
import com.osmium.schoolconnect.backend.service.ICampaignInfoService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/28
 * @Description
 */

@SuppressWarnings("ALL")
@Service
@Validated

public class CampaignAttendeeImpl extends ServiceImpl<CampaignAttendeeMapper, CampaignAttendee> implements ICampaignAttendeeService {
    private final CampaignAttendeeVOMapper campaignAttendeeVOMapper;
    private final ICampaignInfoService iCampaignInfoService;

    public CampaignAttendeeImpl(CampaignAttendeeVOMapper campaignAttendeeVOMapper, ICampaignInfoService iCampaignInfoService) {
        this.campaignAttendeeVOMapper = campaignAttendeeVOMapper;
        this.iCampaignInfoService = iCampaignInfoService;
    }

    @Override
    public List<String> listCampaignsIAttended(String userId, String status) {
        return baseMapper.listCampaignsById(userId, status);
    }


    @Override
    public CampaignStatusDTO getUserStatusOfCampaign(String userId, String campaignId) {
        QueryWrapper q = new QueryWrapper();
        q.eq("campaign_id", campaignId);
        q.eq("attendee_id", userId);
        var sus = baseMapper.selectOne(q);
        CampaignStatusDTO c = new CampaignStatusDTO(null, false, false, false);
        if (sus == null)
            return c;
        if (iCampaignInfoService.getCampaignStatus(campaignId).equals(1)) {
            c.setIsStarted(true);
        } else {
            c.setIsStarted(false);
        }
        c.setAttendantId(sus.getId());
        c.setAmISignedUp(true);
        if (sus.getCheckInStatus() == 1) {
            c.setAmICheckedIn(true);
        }


        return c;

    }

    @Override
    public Boolean updateOne(String attendantsId, int i) {

        return baseMapper.updateCheckInStatus(attendantsId,i);
    }


    @Override
    public List<CampaignAttendeeVO> listAttendees(String campaignId) {
        QueryWrapper query = new QueryWrapper();
        query.eq("campaign_id", campaignId);
        return campaignAttendeeVOMapper.selectList(query);
    }


}
