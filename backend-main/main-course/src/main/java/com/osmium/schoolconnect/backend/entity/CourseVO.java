package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author
 * @Date 2023/4/19
 * @Description
 */
@Data
@TableName("v_course_info")
public class CourseVO extends Course{
    private String courseTeacherName;
}
