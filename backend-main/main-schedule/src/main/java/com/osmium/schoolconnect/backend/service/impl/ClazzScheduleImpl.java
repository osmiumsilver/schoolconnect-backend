package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.ClazzSchedule;
import com.osmium.schoolconnect.backend.entity.pojo.ClazzScheduleVO;
import com.osmium.schoolconnect.backend.mapper.ClazzScheduleMapper;
import com.osmium.schoolconnect.backend.mapper.ClazzScheduleVOMapper;
import com.osmium.schoolconnect.backend.service.IClazzScheduleService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/19
 * @Description
 */
@Service
@Validated
public class ClazzScheduleImpl extends ServiceImpl<ClazzScheduleMapper, ClazzSchedule> implements IClazzScheduleService {
    private final ClazzScheduleVOMapper clazzScheduleVOMapper;

    public ClazzScheduleImpl(ClazzScheduleVOMapper clazzScheduleVOMapper) {
        this.clazzScheduleVOMapper = clazzScheduleVOMapper;
    }

    public List<ClazzScheduleVO> listClazzScheduleByClazz(String classNo, String year, String semester) {
        //QueryWrapper<ClazzSchedule> c = new QueryWrapper<>();
        //c.eq("class_no", classNo);
        //c.like("year", year);
        //c.like("semester", semester);
        //
        //return baseMapper.selectList(c);
        return clazzScheduleVOMapper.selectScheduleDetailsByClazz(classNo,semester,year);
    }

    @Override
    public List<ClazzScheduleVO> listScheduleByTeacher(String userId, String year, String semester) {

        return clazzScheduleVOMapper.listScheduleByTeacher(userId, year, semester);
    }

}
