package com.osmium.schoolconnect.backend.main.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.main.entity.DepartmentInfo;
import com.osmium.schoolconnect.backend.main.mapper.DepartmentInfoMapper;
import com.osmium.schoolconnect.backend.main.service.IDepartmentInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author abel
 * @since 2023-01-12
 */
@Service
public class DepartmentInfoServiceImpl extends ServiceImpl<DepartmentInfoMapper, DepartmentInfo> implements IDepartmentInfoService {

}
