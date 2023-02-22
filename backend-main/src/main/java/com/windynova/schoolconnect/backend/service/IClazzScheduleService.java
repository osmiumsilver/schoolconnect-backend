package com.osmium.schoolconnect.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.osmium.schoolconnect.backend.entity.ClazzSchedule;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/19
 * @Description
 */
public interface IClazzScheduleService extends IService<ClazzSchedule> {
    List<ClazzSchedule> listClazzScheduleByClazz(String classNo, String year, String semester);
}
