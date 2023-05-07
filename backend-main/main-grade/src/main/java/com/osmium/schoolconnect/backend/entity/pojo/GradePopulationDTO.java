package com.osmium.schoolconnect.backend.entity.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author
 * @Date 2023/5/7
 * @Description
 */
@Data
@TableName("v_grade_import")
public class GradePopulationDTO {
    @TableId
    private String id;
    @Excel(name = "学号")
    private String userId;
    @Excel(name = "姓名")
    private String name;
    @Excel(name = "课程号")
    private String courseNo;
    @Excel(name = "班级号")
    private String classNo;
    @Excel(name = "成绩")
    private Double grade;
    @Excel(name = "年份")
    private Integer year;
    @Excel(name = "学期")
    private Integer semester;
}
