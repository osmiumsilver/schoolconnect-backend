package com.osmium.schoolconnect.backend.admin;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTableType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Erupt(name = "课程信息", power = @Power(importable = true, export = true),primaryKeyCol = "courseNo")        //erupt类注解
@Data
@Table(name = "t_course")
@Entity
public class Course implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @EruptField(
            views = @View(title = "课程号"),
            edit = @Edit(title = "课程号",search = @Search(vague = true))
    )
    private @Id String courseNo; //课程ID
    @EruptField(
            views = @View(title = "课程名称"),
            edit = @Edit(title = "课程名称",search = @Search(vague = true))
    )
    private String courseName; //课程名称
    @EruptField(
            views = @View(title = "课程英文名称"),
            edit = @Edit(title = "课程英文名称",search = @Search(vague = true))
    )
    private String courseNameEn; // 课程英文名词

    private Byte courseDuration; //课程时长
    @EruptField(
            views = @View(title = "课程介绍"),
            edit = @Edit(title = "课程介绍",search = @Search(vague = true))
    )

    private String courseDesc; //课程介绍
    @EruptField(
            views = @View(title = "课程地点"),
            edit = @Edit(title = "课程地点",search = @Search(vague = true))
    )
    private String coursePlace; //课程地点
    private Byte courseStatus; //课程状态 0正常，1:结束
    @EruptField(
            views = @View(title = "课程学分"),
            edit = @Edit(title = "课程学分",search = @Search(vague = true))
    )
    private Double courseCredits; //课程学分
    @EruptField(
            views = @View(title = "课程大纲"),
            edit = @Edit(title = "课程大纲",search = @Search(vague = true))
    )

    private String courseOutline;// 课程大纲
    @ManyToOne
    @JoinColumn
    @EruptField(
            views = @View(title = "课程教师",column = "name"),
            edit = @Edit(title = "选择教师", type = EditType.REFERENCE_TABLE,referenceTableType = @ReferenceTableType(id="employeeId",label="name",dependField = "employeeId",dependColumn = "courseTeacher")
    ))
    private User courseTeacher;//课程教师
}