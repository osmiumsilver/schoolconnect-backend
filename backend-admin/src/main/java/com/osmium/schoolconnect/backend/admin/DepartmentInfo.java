package com.osmium.schoolconnect.backend.admin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.View;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

@Erupt(name = "部门信息", power = @Power(importable = true, export = true),primaryKeyCol = "departmentNo")        //erupt类注解
@Data
@Table(name = "t_department")
@Entity
public class DepartmentInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @EruptField(
            views = @View(title = "部门编号"),
            edit = @Edit(title = "部门编号")
    )
    private String departmentNo;
    @EruptField(
            views = @View(title = "部门名称"),
            edit = @Edit(title = "部门名称")
    )
    private String departmentName;

}