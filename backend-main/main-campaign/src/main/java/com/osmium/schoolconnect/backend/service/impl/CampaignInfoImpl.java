package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.CampaignInfo;
import com.osmium.schoolconnect.backend.entity.pojo.CampaignInfoVO;
import com.osmium.schoolconnect.backend.mapper.CampaignInfoMapper;
import com.osmium.schoolconnect.backend.mapper.CampaignInfoPicsVOMapper;
import com.osmium.schoolconnect.backend.mapper.CampaignInfoVOMapper;
import com.osmium.schoolconnect.backend.service.ICampaignInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
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

    private final CampaignInfoVOMapper campaignInfoVOMapper;
    private final CampaignInfoPicsVOMapper campaignInfoPicsVOMapper;

    @Override
    public List<CampaignInfoVO> listCampaignsByLauncher(String campaignLauncher) {
        QueryWrapper<CampaignInfoVO> wrapper = new QueryWrapper<>();
        wrapper.eq("campaign_launcher", campaignLauncher);
        return campaignInfoVOMapper.selectList(wrapper);
    }

    @Override
    public Byte getCampaignStatus(String campaignId) {

        return baseMapper.selectByteForCampaignStatus(campaignId);
    }


    public CampaignInfoVO getById(Serializable id) {
        return campaignInfoVOMapper.selectById(id);
    }

    @Override
    public List<CampaignInfo> getCampaignByStatus(String status) {
        QueryWrapper<CampaignInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("campaign_status", status);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<CampaignInfo> listCampaignsUserSignedUpFor(String user, String campaignStatus) {
        return baseMapper.listCampaignsUserSignedUpFor(user, Integer.valueOf(campaignStatus));
    }

    @Override
    public List<String> listPictures(String campaignId) {
        QueryWrapper query = new QueryWrapper<>();
        query.select("picture_url").eq("campaign_id", campaignId);
        return campaignInfoPicsVOMapper.selectList(query);
    }
}
