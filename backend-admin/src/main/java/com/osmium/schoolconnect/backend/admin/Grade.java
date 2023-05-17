package com.osmium.schoolconnect.backend.admin;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.ChoiceType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.annotation.sub_field.sub_edit.VL;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


@EqualsAndHashCode(callSuper = true)
@Erupt(name = "成绩管理", power = @Power(importable = true, export = true))        //erupt类注解
@Data
@Table(name = "t_grade")
@Entity
public class Grade extends BaseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @EruptField(
            views = @View(title = "学号"),
            edit = @Edit(title = "学号",search = @Search(vague = true))
    )
    private String userId; //学号
    @EruptField(
            views = @View(title = "课程号"),
            edit = @Edit(title = "课程号",search = @Search(vague = true))
    )
    private String courseNo; //课程编号
    @EruptField(
            views = @View(title = "成绩"),
            edit = @Edit(title = "成绩")
    )
    private Double grade; //成绩
    @EruptField(
            views = @View(title = "学年"),
            edit = @Edit(title = "学年")
    )
    private int year; //学年
    @EruptField(
            views = @View(title = "学期"),
            edit = @Edit(title = "学期")
    )
    private int semester; //学期
    @EruptField(
            views = @View(title = "导入日期")
    )
    private LocalDateTime importDate; //导入时间

    @EruptField(
            views = @View(title = "需要审核"),
            edit = @Edit(title = "需要审核", type = EditType.CHOICE, choiceType = @ChoiceType(vl = {
                    @VL(value = "0", label = "正常"),
                    @VL(value = "1", label = "需要修改"),
                    @VL(value = "2", label = "审核中")})))
    private Byte awaitingRevision;

}


