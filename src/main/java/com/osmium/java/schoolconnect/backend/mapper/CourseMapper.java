package com.osmium.java.schoolconnect.backend.mapper;

import com.osmium.java.schoolconnect.backend.entity.Course;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface CourseMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Delete({
        "delete from course",
        "where courseno = #{courseno,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer courseno);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Insert({
        "insert into course (courseno, coursename, ",
        "courseduration, coursetype, ",
        "coursedesc, courseplace, ",
        "coursestatus, courseteacher, ",
        "coursecredits)",
        "values (#{courseno,jdbcType=INTEGER}, #{coursename,jdbcType=VARCHAR}, ",
        "#{courseduration,jdbcType=TINYINT}, #{coursetype,jdbcType=TINYINT}, ",
        "#{coursedesc,jdbcType=VARCHAR}, #{courseplace,jdbcType=VARCHAR}, ",
        "#{coursestatus,jdbcType=TINYINT}, #{courseteacher,jdbcType=VARCHAR}, ",
        "#{coursecredits,jdbcType=TINYINT})"
    })
    int insert(Course row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Select({
        "select",
        "courseno, coursename, courseduration, coursetype, coursedesc, courseplace, coursestatus, ",
        "courseteacher, coursecredits",
        "from course",
        "where courseno = #{courseno,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="courseno", property="courseno", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="coursename", property="coursename", jdbcType=JdbcType.VARCHAR),
        @Result(column="courseduration", property="courseduration", jdbcType=JdbcType.TINYINT),
        @Result(column="coursetype", property="coursetype", jdbcType=JdbcType.TINYINT),
        @Result(column="coursedesc", property="coursedesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="courseplace", property="courseplace", jdbcType=JdbcType.VARCHAR),
        @Result(column="coursestatus", property="coursestatus", jdbcType=JdbcType.TINYINT),
        @Result(column="courseteacher", property="courseteacher", jdbcType=JdbcType.VARCHAR),
        @Result(column="coursecredits", property="coursecredits", jdbcType=JdbcType.TINYINT)
    })
    Course selectByPrimaryKey(Integer courseno);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Select({
        "select",
        "courseno, coursename, courseduration, coursetype, coursedesc, courseplace, coursestatus, ",
        "courseteacher, coursecredits",
        "from course"
    })
    @Results({
        @Result(column="courseno", property="courseno", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="coursename", property="coursename", jdbcType=JdbcType.VARCHAR),
        @Result(column="courseduration", property="courseduration", jdbcType=JdbcType.TINYINT),
        @Result(column="coursetype", property="coursetype", jdbcType=JdbcType.TINYINT),
        @Result(column="coursedesc", property="coursedesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="courseplace", property="courseplace", jdbcType=JdbcType.VARCHAR),
        @Result(column="coursestatus", property="coursestatus", jdbcType=JdbcType.TINYINT),
        @Result(column="courseteacher", property="courseteacher", jdbcType=JdbcType.VARCHAR),
        @Result(column="coursecredits", property="coursecredits", jdbcType=JdbcType.TINYINT)
    })
    List<Course> selectAll();

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Update({
        "update course",
        "set coursename = #{coursename,jdbcType=VARCHAR},",
          "courseduration = #{courseduration,jdbcType=TINYINT},",
          "coursetype = #{coursetype,jdbcType=TINYINT},",
          "coursedesc = #{coursedesc,jdbcType=VARCHAR},",
          "courseplace = #{courseplace,jdbcType=VARCHAR},",
          "coursestatus = #{coursestatus,jdbcType=TINYINT},",
          "courseteacher = #{courseteacher,jdbcType=VARCHAR},",
          "coursecredits = #{coursecredits,jdbcType=TINYINT}",
        "where courseno = #{courseno,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Course row);
}