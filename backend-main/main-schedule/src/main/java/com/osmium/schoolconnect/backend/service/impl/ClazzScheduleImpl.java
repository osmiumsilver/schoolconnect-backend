package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.ClazzSchedule;
import com.osmium.schoolconnect.backend.mapper.ClazzScheduleMapper;
import com.osmium.schoolconnect.backend.service.IClazzScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/19
 * @Description
 */
@Service
public class ClazzScheduleImpl extends ServiceImpl<ClazzScheduleMapper, ClazzSchedule> implements IClazzScheduleService {
    public List<ClazzSchedule> listClazzScheduleByClazz(String classNo, String year, String semester) {
        //QueryWrapper<ClazzSchedule> c = new QueryWrapper<>();
        //c.eq("class_no", classNo);
        //c.like("year", year);
        //c.like("semester", semester);
        //
        //return baseMapper.selectList(c);
        return baseMapper.selectScheduleDetailsByClazz(classNo,semester,year);
    }

    @Override
    public List<ClazzSchedule> listScheduleByTeacher(String userId, String year, String semester) {

        return baseMapper.listScheduleByTeacher(userId, year, semester);
    }

}
