package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.CampaignSubscription;
import com.osmium.schoolconnect.backend.mapper.CampaignSubscriptionMapper;
import com.osmium.schoolconnect.backend.service.ICampaignSubscriptionService;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author
 * @Date 2023/4/18
 * @Description
 */
@Repository
public class CampaignSubscriptionImpl extends ServiceImpl<CampaignSubscriptionMapper, CampaignSubscription> implements ICampaignSubscriptionService {


}
