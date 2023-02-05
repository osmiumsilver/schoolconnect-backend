package com.osmium.schoolconnect.backend.main.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.main.entity.Course;
import com.osmium.schoolconnect.backend.main.mapper.CourseMapper;
import com.osmium.schoolconnect.backend.main.service.ICourseService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生参与的课程表 服务实现类
 * </p>
 *
 * @author abel
 * @since 2023-01-12
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

}
