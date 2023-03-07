package com.schoolconnect.common.core.domain.entity;

import com.schoolconnect.common.annotation.Excel;
import com.schoolconnect.common.annotation.Excel.ColumnType;
import com.schoolconnect.common.constant.UserConstants;
import com.schoolconnect.common.core.domain.BaseEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 字典数据表 sys_dict_data
 */
@Data
public class SysDictData extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 字典编码
     */
    @Excel(name = "字典编码", cellType = ColumnType.NUMERIC)
    private Long dictCode;

    /**
     * 字典排序
     */
    @Excel(name = "字典排序", cellType = ColumnType.NUMERIC)
    private Long dictSort;

    @NotBlank(message = "字典标签不能为空") @Size(min = 0, max = 100, message = "字典标签长度不能超过100个字符")
    /** 字典标签 */
    @Excel(name = "字典标签")
    private String dictLabel;

    @NotBlank(message = "字典键值不能为空") @Size(min = 0, max = 100, message = "字典键值长度不能超过100个字符")
    /** 字典键值 */
    @Excel(name = "字典键值")
    private String dictValue;

    @NotBlank(message = "字典类型不能为空") @Size(min = 0, max = 100, message = "字典类型长度不能超过100个字符")
    /** 字典类型 */
    @Excel(name = "字典类型")
    private String dictType;

    @Size(min = 0, max = 100, message = "样式属性长度不能超过100个字符")
    /** 样式属性（其他样式扩展） */
    private String cssClass;

    /**
     * 表格字典样式
     */
    private String listClass;

    /**
     * 是否默认（Y是 N否）
     */
    @Excel(name = "是否默认", readConverterExp = "Y=是,N=否")
    private String isDefault;

    /**
     * 状态（0正常 1停用）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public boolean getDefault() {
        return UserConstants.YES.equals(this.isDefault);
    }

}
