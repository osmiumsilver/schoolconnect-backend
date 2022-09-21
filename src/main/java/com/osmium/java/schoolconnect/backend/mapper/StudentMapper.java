package com.osmium.java.schoolconnect.backend.mapper;

import com.osmium.java.schoolconnect.backend.entity.User;

import java.util.List;

public interface StudentMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String sno);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(User row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    User selectByPrimaryKey(String sno);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<User> selectAll();

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(User row);
}