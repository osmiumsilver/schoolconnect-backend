package com.osmium.schoolconnect.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.osmium.schoolconnect.backend.entity.DepartmentManagerInfo;

import java.util.List;

/**
 * <p>
 * 部门负责人信息 服务类
 * </p>
 *
 * @author abel
 * @since 2023-01-12
 */
public interface IDepartmentManagerInfoService extends IService<DepartmentManagerInfo> {
    List<DepartmentManagerInfo> getManagersByDepartment(List<DepartmentManagerInfo> managerId);

}
