package com.osmium.schoolconnect.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.Grade;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
@Mapper
public interface GradeMapper extends BaseMapper<Grade> {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Delete({
        "delete from grade",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Insert({
        "insert into grade (userno, grade, ",
        "courseno)",
        "values (#{userno,jdbcType=INTEGER}, #{grade,jdbcType=TINYINT}, ",
        "#{courseno,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(Grade row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Select({
        "select",
        "id, userno, grade, courseno",
        "from grade",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="userno", property="userno", jdbcType=JdbcType.INTEGER),
        @Result(column="grade", property="grade", jdbcType=JdbcType.TINYINT),
        @Result(column="courseno", property="courseno", jdbcType=JdbcType.INTEGER)
    })
    Grade selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Select({
        "select",
        "id, userno, grade, courseno",
        "from grade"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="userno", property="userno", jdbcType=JdbcType.INTEGER),
        @Result(column="grade", property="grade", jdbcType=JdbcType.TINYINT),
        @Result(column="courseno", property="courseno", jdbcType=JdbcType.INTEGER)
    })
    List<Grade> selectAll();

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Update({
        "update grade",
        "set userno = #{userno,jdbcType=INTEGER},",
          "grade = #{grade,jdbcType=TINYINT},",
          "courseno = #{courseno,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Grade row);
}