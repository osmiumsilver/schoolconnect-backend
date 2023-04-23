package com.osmium.schoolconnect.backend.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.osmium.schoolconnect.backend.entity.ClazzSchedule;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author
 * @Date 2023/4/19
 * @Description
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("v_class_schedule")
public class ClazzScheduleVO extends ClazzSchedule {
    private String courseName;
    private String coursePlace;
    private String courseTeacherName;
    private Byte courseCredits;
}
