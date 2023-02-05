package com.osmium.schoolconnect.backend.main.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.main.entity.CourseInfo;
import com.osmium.schoolconnect.backend.main.mapper.CourseInfoMapper;
import com.osmium.schoolconnect.backend.main.service.ICourseInfoService;
import org.springframework.stereotype.Service;

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

}
