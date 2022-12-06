package com.osmium.schoolconnect.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.Grade;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface GradeMapper extends BaseMapper<Grade> {
}