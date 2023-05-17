package com.osmium.schoolconnect.backend.admin;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.ChoiceType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.annotation.sub_field.sub_edit.VL;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

@Erupt(name = "活动信息", power = @Power(importable = true, export = true),primaryKeyCol = "classNo")        //erupt类注解
@Data
@Table(name = "t_class")
@Entity
public class Clazz implements Serializable {
   @Id
   @EruptField(
           views = @View(title = "班级编号"),
           edit = @Edit(title = "班级编号",search = @Search(vague = true))
   )
    private String classNo; //班级编号
 @EruptField(
         views = @View(title = "班级名称"),
         edit = @Edit(title = "班级名称",search = @Search(vague = true))
 )
    private String className; //班级名称
 @EruptField(
         views = @View(title = "部门编号"),
         edit = @Edit(title = "部门编号",search = @Search(vague = true))
 )
    private String departmentNo; //部门编号
    //private String departmentName; //部门名称
    @EruptField(
            views = @View(title = "年份"),
            edit = @Edit(title = "年份",search = @Search(vague = true))
    )
    private String year; //年份
 @EruptField(
         views = @View(title = "班级状态"),
         edit = @Edit(title = "班级状态", type = EditType.CHOICE, choiceType = @ChoiceType(vl = {
                 @VL(value = "0", label = "默认"),
                 @VL(value = "1", label = "已毕业")})))
    private Byte status; //班级状态 0默认 1毕业
}