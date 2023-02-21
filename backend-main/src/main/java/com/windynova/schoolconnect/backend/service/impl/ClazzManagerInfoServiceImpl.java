package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.ClazzManagerInfo;
import com.osmium.schoolconnect.backend.mapper.ClazzManagerInfoMapper;
import com.osmium.schoolconnect.backend.service.IClazzManagerInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 班级管理人员信息 服务实现类
 * </p>
 *
 * @author abel
 * @since 2023-01-12
 */
@Service
public class ClazzManagerInfoServiceImpl extends ServiceImpl<ClazzManagerInfoMapper, ClazzManagerInfo> implements IClazzManagerInfoService {

}
