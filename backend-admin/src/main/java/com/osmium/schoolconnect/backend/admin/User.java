package com.osmium.schoolconnect.backend.admin;

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
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @Author
 * @Date 2023/5/9
 * @Description
 */
@Erupt(name = "学生管理", power = @Power(importable = true, export = true),primaryKeyCol = "employeeId")        //erupt类注解
@Table(name = "t_user")    //数据库表名
@Data
@Entity//hibernate实体类标识
public class User  {
    @Id
    @EruptField(
            views = @View(title = "工号"),
            edit = @Edit(title = "工号",search = @Search(vague = true))
    )
    private Long employeeId; //工号

    @EruptField(
            views = @View(title = "照片URL"),
            edit = @Edit(title = "照片URL")
    )
    private String pictureUrl; //照片URL
    @EruptField(
            views = @View(title = "姓名"),
            edit = @Edit(title = "姓名",search = @Search(vague = true))
    )
    private String name; //姓名
    @EruptField(
            views = @View(title = "性别"),
            edit = @Edit(title = "性别",
                    type = EditType.CHOICE, choiceType = @ChoiceType(vl = {
                    @VL(value = "0", label = "男"),
                    @VL(value = "1", label = "女")
            })))
    private Integer sex; //表示性别 0:男 1:女
    @EruptField(
            views = @View(title = "身份证号码"),
            edit = @Edit(title = "身份证号码",search = @Search(vague = true))
    )
    private String residenceId; //身份证号码等证件号
    @EruptField(
            views = @View(title = "邮箱"),
            edit = @Edit(title = "邮箱")
    )
    private String email; //邮箱
    @EruptField(
            views = @View(title = "手机号"),
            edit = @Edit(title = "手机号")
    )
    private String phone; //手机号码
    @EruptField(
            views = @View(title = "地址"),
            edit = @Edit(title = "地址")
    )
    private String address; //地址
    @EruptField(
            views = @View(title = "第二联系方式"),
            edit = @Edit(title = "身份证号码")
    )
    private String secondContact; //第二联系方式
    @EruptField(
            views = @View(title = "身份"),
            edit = @Edit(title = "身份", type = EditType.CHOICE, choiceType = @ChoiceType(vl = {
                    @VL(value = "0", label = "超管"),
                    @VL(value = "1", label = "教务员"),
                    @VL(value = "2", label = "教师"),
                    @VL(value = "3", label = "学生"),
                    @VL(value = "4", label = "来宾")}),search = @Search(vague = true)))
    private Integer role;

    @EruptField(
            views = @View(title = "状态"),
            edit = @Edit(title = "状态", type = EditType.CHOICE, choiceType = @ChoiceType(vl = {
                    @VL(value = "0", label = "正常"),
                    @VL(value = "1", label = "离校"),
                    @VL(value = "2", label = "开除"),
                    @VL(value = "3", label = "冻结")}),search = @Search(vague = true)))
    private Integer status; //状态

    private LocalDateTime createTime; //创建时间


    @EruptField(
            views = @View(title = "需要审核"),
            edit = @Edit(title = "需要审核", type = EditType.CHOICE, choiceType = @ChoiceType(vl = {
                    @VL(value = "0", label = "正常"),
                    @VL(value = "1", label = "需要修改"),
                    @VL(value = "2", label = "审核中")})))
    private Integer requiredChanging;//是否需要修改 0为不需要 1为需要 2为审核中


}