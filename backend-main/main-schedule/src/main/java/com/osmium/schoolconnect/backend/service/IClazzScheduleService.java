package com.osmium.schoolconnect.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.osmium.schoolconnect.backend.entity.ClazzSchedule;
import com.osmium.schoolconnect.backend.entity.pojo.ClazzScheduleVO;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/19
 * @Description
 */
public interface IClazzScheduleService extends IService<ClazzSchedule> {
    List<ClazzScheduleVO> listClazzScheduleByClazz(String classNo, String year, String semester);

    List<ClazzScheduleVO> listScheduleByTeacher(String userId, String year, String semester);
}
