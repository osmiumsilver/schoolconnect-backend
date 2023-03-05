package com.schoolconnect.common.core.domain.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.schoolconnect.common.annotation.Excel;
import com.schoolconnect.common.annotation.Excel.ColumnType;
import com.schoolconnect.common.core.domain.BaseEntity;

/**
 * 字典类型表 sys_dict_type

 */
@Data
public class SysDictType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 字典主键 */
    @Excel(name = "字典主键", cellType = ColumnType.NUMERIC)
    private Long dictId;

    @NotBlank(message = "字典名称不能为空")@Size(min = 0, max = 100, message = "字典类型名称长度不能超过100个字符")
    /** 字典名称 */
    @Excel(name = "字典名称")
    private String dictName;

    @NotBlank(message = "字典类型不能为空")@Size(min = 0, max = 100, message = "字典类型类型长度不能超过100个字符")@Pattern(regexp = "^[a-z][a-z0-9_]*$", message = "字典类型必须以字母开头，且只能为（小写字母，数字，下滑线）")
    /** 字典类型 */
    @Excel(name = "字典类型")
    private String dictType;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

}