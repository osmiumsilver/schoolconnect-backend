package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.CampaignInfo;
import com.osmium.schoolconnect.backend.mapper.CampaignInfoMapper;
import com.osmium.schoolconnect.backend.service.ICampaignInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/28
 * @Description
 */
@Service
public class CampaignInfoImpl extends ServiceImpl<CampaignInfoMapper, CampaignInfo> implements ICampaignInfoService {
    @Override
    public List<CampaignInfo> listCampaignsByLauncher(String campaignLauncher) {
        QueryWrapper<CampaignInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("campaign_launcher", campaignLauncher);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<CampaignInfo> getOngoingCampaigns() {
        QueryWrapper<CampaignInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("campaign_status", 0);
        return baseMapper.selectList(wrapper);
    }
}
