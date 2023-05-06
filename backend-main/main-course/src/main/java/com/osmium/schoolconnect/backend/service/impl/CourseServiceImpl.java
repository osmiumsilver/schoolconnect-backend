package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.Course;
import com.osmium.schoolconnect.backend.mapper.CourseMapper;
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
    public String getName(String courseId) {
        return baseMapper.getName(courseId);
    }

    @Override
    public List<String> listClazzesTaughtByTeacher(String name) {
        return baseMapper.selectClazzesTaughtByTeacher(name);
    }

    @Override
    public List<String> listCoursesTaughtByTeacher(String userId) {
        return baseMapper.selectList(userId);
    }


}
