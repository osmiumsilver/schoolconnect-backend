package com.osmium.schoolconnect.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.osmium.schoolconnect.backend.entity.Course;

import java.util.List;

/**
 * <p>
 * 课程表 服务类
 * </p>
 *
 * @author abel
 * @since 2023-01-12
 */
public interface ICourseService extends IService<Course> {

    List<Course> listCoursesTaughtByTeacher(String userId);


}
