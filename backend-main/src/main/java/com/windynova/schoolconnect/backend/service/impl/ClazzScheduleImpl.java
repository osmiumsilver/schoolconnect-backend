package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.ClazzSchedule;
import com.osmium.schoolconnect.backend.mapper.ClazzScheduleMapper;
import com.osmium.schoolconnect.backend.service.IClazzScheduleService;
import org.springframework.stereotype.Service;

/**
 * @Author
 * @Date 2023/2/19
 * @Description
 */
@Service
public class ClazzScheduleImpl extends ServiceImpl<ClazzScheduleMapper, ClazzSchedule> implements IClazzScheduleService {
}
