package com.osmium.schoolconnect.backend.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.CampaignInfoPics;
import com.osmium.schoolconnect.backend.mapper.CampaignInfoPicsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

/**
 * @Author
 * @Date 2023/4/14
 * @Description
 */
@Repository
@Validated
@RequiredArgsConstructor
public class CampaignInfoPicsImpl extends ServiceImpl<CampaignInfoPicsMapper, CampaignInfoPics> {
}
