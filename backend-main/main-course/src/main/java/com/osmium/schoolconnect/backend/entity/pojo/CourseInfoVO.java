package com.osmium.schoolconnect.backend.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.osmium.schoolconnect.backend.entity.Course;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author
 * @Date 2023/4/19
 * @Description
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("v_course_info")
public class CourseInfoVO extends Course {
    private String courseTeacherName;
}
