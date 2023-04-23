package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.Course;
import com.osmium.schoolconnect.backend.mapper.CourseMapper;
import com.osmium.schoolconnect.backend.mapper.CourseVOMapper;
import com.osmium.schoolconnect.backend.service.ICourseService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * <p>
 * 课程表 服务实现类
 * </p>
 *
 * @author abel
 * @since 2023-01-12
 */
@Service
@Validated
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {




    @Override
    public List<String> listClazzesTaughtByTeacher(String name) {
        return baseMapper.selectClazzesTaughtByTeacher(name);
    }

    @Override
    public List<Course> listCoursesTaughtByTeacher(String userId) {
        QueryWrapper q = new QueryWrapper<>();
        q.eq("course_teacher", userId);

        return baseMapper.selectList(q);
    }


}
