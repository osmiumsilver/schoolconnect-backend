package com.osmium.schoolconnect.backend.admin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.ChoiceType;
import xyz.erupt.annotation.sub_field.sub_edit.DateType;
import xyz.erupt.annotation.sub_field.sub_edit.VL;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @Author
 * @Date 2023/2/28
 * @Description
 */
@Erupt(name = "活动信息", power = @Power(importable = true, export = true))        //erupt类注解
@Data
@Table(name = "t_campaign_info")
@Entity
public class CampaignInfo extends BaseModel{

    @EruptField(
            views = @View(title = "活动名称"),
            edit = @Edit(title = "活动名称")
    )
    private String campaignName;
    @EruptField(
            views = @View(title = "活动介绍"),
            edit = @Edit(title = "活动介绍")
    )
    private String campaignDescription;
    @EruptField(
            views = @View(title = "活动地点"),
            edit = @Edit(title = "活动地点")
    )
    private String campaignLocation;
    @EruptField(
            views = @View(title = "活动时间"),
            edit = @Edit(title = "活动时间" ,type = EditType.DATE, dateType = @DateType(type = DateType.Type.DATE_TIME)))
    private LocalDateTime campaignTime;
    @EruptField(
            views = @View(title = "活动发起人"),
            edit = @Edit(title = "活动发起人")
    )
    private String campaignLauncher;
    @EruptField(
            views = @View(title = "联系电话"),
            edit = @Edit(title = "联系电话")
    )
    private String contactPhone;
    @EruptField(
            views = @View(title = "活动状态"),
            edit = @Edit(title = "活动状态", type = EditType.CHOICE, choiceType = @ChoiceType(vl = {
                    @VL(value = "0", label = "报名中"),
                    @VL(value = "1", label = "已开始"),
                    @VL(value = "2", label = "已结束")})))
    private Byte campaignStatus;

}
