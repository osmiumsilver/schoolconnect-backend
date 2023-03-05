package com.osmium.schoolconnect.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.osmium.schoolconnect.backend.entity.Clazz;
import com.osmium.schoolconnect.backend.entity.ClazzManagerInfo;

import java.util.List;

/**
 * <p>
 * 班级管理人员信息 服务类
 * </p>
 *
 * @author abel
 * @since 2023-01-12
 */
public interface IClazzManagerInfoService extends IService<ClazzManagerInfo> {
    List<Clazz> getClazzManagedByStaff(String employeeId);

}
