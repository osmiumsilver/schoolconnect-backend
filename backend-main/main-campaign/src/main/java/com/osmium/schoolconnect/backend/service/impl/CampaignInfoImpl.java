package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.CampaignInfo;
import com.osmium.schoolconnect.backend.mapper.CampaignInfoMapper;
import com.osmium.schoolconnect.backend.service.ICampaignInfoService;
import lombok.RequiredArgsConstructor;
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
public class CampaignInfoImpl extends ServiceImpl<CampaignInfoMapper, CampaignInfo> implements ICampaignInfoService {
    @Override
    public List<CampaignInfo> listCampaignsByLauncher(String campaignLauncher) {
        QueryWrapper<CampaignInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("campaign_launcher", campaignLauncher);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<CampaignInfo> searchByName(String name) {
        QueryWrapper<CampaignInfo> wrapper = new QueryWrapper<>();
wrapper.like("campaign_name", name);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<CampaignInfo> getOngoingCampaigns(String status) {
        QueryWrapper<CampaignInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("campaign_status", status);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<CampaignInfo> listCampaignsUserSignedUpFor(String user,String campaignStatus) {
        return baseMapper.listCampaignsUserSignedUpFor(user, Integer.valueOf(campaignStatus));
    }
}
