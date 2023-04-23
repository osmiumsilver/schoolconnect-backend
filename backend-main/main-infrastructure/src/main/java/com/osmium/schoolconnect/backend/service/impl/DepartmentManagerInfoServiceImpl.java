package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.DepartmentManagerInfo;
import com.osmium.schoolconnect.backend.mapper.DepartmentManagerInfoMapper;
import com.osmium.schoolconnect.backend.service.IDepartmentManagerInfoService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * <p>
 * 部门负责人信息 服务实现类
 * </p>
 *
 * @author abel
 * @since 2023-01-12
 */
@Service
@Validated
public class DepartmentManagerInfoServiceImpl extends ServiceImpl<DepartmentManagerInfoMapper, DepartmentManagerInfo> implements IDepartmentManagerInfoService {

    public List<DepartmentManagerInfo> getManagersByDepartment(List<DepartmentManagerInfo> managerId) {

        QueryWrapper<DepartmentManagerInfo> departmentManagerInfoLambdaQueryWrapper = new QueryWrapper<>();
        departmentManagerInfoLambdaQueryWrapper.eq("employee_id", managerId);
        return baseMapper.selectList(departmentManagerInfoLambdaQueryWrapper);
    }
}
