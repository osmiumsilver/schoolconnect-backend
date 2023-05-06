package com.osmium.schoolconnect.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.osmium.schoolconnect.backend.entity.Clazz;
import com.osmium.schoolconnect.backend.entity.DepartmentInfo;

import java.util.List;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author abel
 * @since 2023-01-12
 */
public interface IDepartmentInfoService extends IService<DepartmentInfo> {
    List<Clazz> listClazzesByDepartment(String departmentId);
}
