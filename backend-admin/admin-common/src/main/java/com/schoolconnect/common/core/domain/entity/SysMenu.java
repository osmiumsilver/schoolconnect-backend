package com.schoolconnect.common.core.domain.entity;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.schoolconnect.common.core.domain.BaseEntity;

/**
 * 菜单权限表 sys_menu

 */
@Data
public class SysMenu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 菜单ID */
    private Long menuId;

    @NotBlank(message = "菜单名称不能为空")@Size(min = 0, max = 50, message = "菜单名称长度不能超过50个字符")
    /** 菜单名称 */
    private String menuName;

    /** 父菜单名称 */
    private String parentName;

    /** 父菜单ID */
    private Long parentId;

    @NotNull(message = "显示顺序不能为空")
    /** 显示顺序 */
    private Integer orderNum;

    @Size(min = 0, max = 200, message = "路由地址不能超过200个字符")
    /** 路由地址 */
    private String path;

    @Size(min = 0, max = 200, message = "组件路径不能超过255个字符")
    /** 组件路径 */
    private String component;

    /** 路由参数 */
    private String query;

    /** 是否为外链（0是 1否） */
    private String isFrame;

    /** 是否缓存（0缓存 1不缓存） */
    private String isCache;

    @NotBlank(message = "菜单类型不能为空")
    /** 类型（M目录 C菜单 F按钮） */
    private String menuType;

    /** 显示状态（0显示 1隐藏） */
    private String visible;
    
    /** 菜单状态（0正常 1停用） */
    private String status;

    @Size(min = 0, max = 100, message = "权限标识长度不能超过100个字符")
    /** 权限字符串 */
    private String perms;

    /** 菜单图标 */
    private String icon;

    /** 子菜单 */
    private List<SysMenu> children = new ArrayList<>();

}