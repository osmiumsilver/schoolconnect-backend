package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.CourseInfo;
import com.osmium.schoolconnect.backend.mapper.CourseInfoMapper;
import com.osmium.schoolconnect.backend.service.ICourseInfoService;
import org.springframework.stereotype.Service;

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
public class CourseInfoServiceImpl extends ServiceImpl<CourseInfoMapper, CourseInfo> implements ICourseInfoService {

    @Override
    public List<CourseInfo> getCoursesByTeacher(String userId) {
 return baseMapper.getCoursesByTeacher(userId);
    }
}
