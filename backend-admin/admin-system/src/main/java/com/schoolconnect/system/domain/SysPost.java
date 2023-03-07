package com.schoolconnect.system.domain;

import com.schoolconnect.common.annotation.Excel;
import com.schoolconnect.common.annotation.Excel.ColumnType;
import com.schoolconnect.common.core.domain.BaseEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 岗位表 sys_post
 */
@Data
public class SysPost extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 岗位序号
     */
    @Excel(name = "岗位序号", cellType = ColumnType.NUMERIC)
    private Long postId;

    @NotBlank(message = "岗位编码不能为空") @Size(min = 0, max = 64, message = "岗位编码长度不能超过64个字符")
    /** 岗位编码 */
    @Excel(name = "岗位编码")
    private String postCode;

    @NotBlank(message = "岗位名称不能为空") @Size(min = 0, max = 50, message = "岗位名称长度不能超过50个字符")
    /** 岗位名称 */
    @Excel(name = "岗位名称")
    private String postName;

    @NotNull(message = "显示顺序不能为空")
    /** 岗位排序 */
    @Excel(name = "岗位排序")
    private Integer postSort;

    /**
     * 状态（0正常 1停用）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /**
     * 用户是否存在此岗位标识 默认不存在
     */
    private boolean flag = false;

}
