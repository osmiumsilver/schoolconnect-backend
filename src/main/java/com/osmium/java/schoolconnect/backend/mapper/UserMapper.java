package com.osmium.java.schoolconnect.backend.mapper;

import com.osmium.java.schoolconnect.backend.entity.SysUser;

import java.util.List;

public interface UserMapper {

    int deleteByPrimaryKey(String username);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(SysUser row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    SysUser selectByPrimaryKey(String username);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<SysUser> selectAll();

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(SysUser row);
}