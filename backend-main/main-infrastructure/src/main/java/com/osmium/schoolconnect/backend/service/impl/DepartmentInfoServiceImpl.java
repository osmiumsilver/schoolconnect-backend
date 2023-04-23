package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.DepartmentInfo;
import com.osmium.schoolconnect.backend.mapper.DepartmentInfoMapper;
import com.osmium.schoolconnect.backend.service.IDepartmentInfoService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author abel
 * @since 2023-01-12
 */
@Service
@Validated
public class DepartmentInfoServiceImpl extends ServiceImpl<DepartmentInfoMapper, DepartmentInfo> implements IDepartmentInfoService {

}
