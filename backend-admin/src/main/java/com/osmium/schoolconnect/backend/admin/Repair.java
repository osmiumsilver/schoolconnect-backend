package com.osmium.schoolconnect.backend.admin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.ChoiceType;
import xyz.erupt.annotation.sub_field.sub_edit.VL;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;


/**
 * @Author
 * @Date 2023/3/10
 * @Description
 */
@Erupt(name = "活动信息", power = @Power(importable = true, export = true))        //erupt类注解
@Data
@Table(name = "t_repair_data")
@Entity
public class Repair extends BaseModel {

    @EruptField(
            views = @View(title = "报修详情"),
            edit = @Edit(title = "报修详情")
    )
    private String description;
    @EruptField(
            views = @View(title = "电话"),
            edit = @Edit(title = "电话")
    )
    private String phone;
    @EruptField(
            views = @View(title = "报修位置"),
            edit = @Edit(title = "报修位置")
    )
    private String location;

    @EruptField(
            views = @View(title = "报修状态"),
            edit = @Edit(title = "报修状态", type = EditType.CHOICE, choiceType = @ChoiceType(vl = {
                    @VL(value = "0", label = "报修中"),
                    @VL(value = "1", label = "正在报修"),
                    @VL(value = "2", label = "已结束")})))
    private Byte status;
    @EruptField(
            views = @View(title = "报修等级"),
            edit = @Edit(title = "报修等级", type = EditType.CHOICE, choiceType = @ChoiceType(vl = {
                    @VL(value = "0", label = "普通报修"),
                    @VL(value = "1", label = "加急报修")})))
    private Byte level;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @EruptField(
            views = @View(title = "报修时间"),
            edit = @Edit(title = "报修时间")
    )
    private LocalDateTime createTime;
    @EruptField(
            views = @View(title = "报修发起人"),
            edit = @Edit(title = "报修发起人")
    )
    private String initiator; //发起人
}
