package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.CampaignAttendee;
import com.osmium.schoolconnect.backend.entity.CampaignInfo;
import com.osmium.schoolconnect.backend.mapper.CampaignAttendeeMapper;
import com.osmium.schoolconnect.backend.mapper.CampaignInfoMapper;
import com.osmium.schoolconnect.backend.service.ICampaignAttendeeService;
import com.osmium.schoolconnect.backend.service.ICampaignInfoService;
import org.springframework.stereotype.Service;

/**
 * @Author
 * @Date 2023/2/28
 * @Description
 */
@Service
public class CampaignAttendeeImpl extends ServiceImpl<CampaignAttendeeMapper, CampaignAttendee> implements ICampaignAttendeeService {
}
