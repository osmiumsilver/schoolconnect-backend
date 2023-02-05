package com.osmium.schoolconnect.backend.main.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.main.entity.DepartmentManagerInfo;
import com.osmium.schoolconnect.backend.main.mapper.DepartmentManagerInfoMapper;
import com.osmium.schoolconnect.backend.main.service.IDepartmentManagerInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门负责人信息 服务实现类
 * </p>
 *
 * @author abel
 * @since 2023-01-12
 */
@Service
public class DepartmentManagerInfoServiceImpl extends ServiceImpl<DepartmentManagerInfoMapper, DepartmentManagerInfo> implements IDepartmentManagerInfoService {
}
