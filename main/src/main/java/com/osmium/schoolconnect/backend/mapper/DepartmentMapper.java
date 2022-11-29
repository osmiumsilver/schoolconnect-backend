package com.osmium.schoolconnect.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.Department;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface DepartmentMapper extends BaseMapper<Department> {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Delete({
        "delete from department",
        "where dno = #{dno,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer dno);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Insert({
        "insert into department (dno, dname, ",
        "dmanagerno, dmanagername)",
        "values (#{dno,jdbcType=INTEGER}, #{dname,jdbcType=VARCHAR}, ",
        "#{dmanagerno,jdbcType=INTEGER}, #{dmanagername,jdbcType=VARCHAR})"
    })
    int insert(Department row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Select({
        "select",
        "dno, dname, dmanagerno, dmanagername",
        "from department",
        "where dno = #{dno,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="dno", property="dno", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="dname", property="dname", jdbcType=JdbcType.VARCHAR),
        @Result(column="dmanagerno", property="dmanagerno", jdbcType=JdbcType.INTEGER),
        @Result(column="dmanagername", property="dmanagername", jdbcType=JdbcType.VARCHAR)
    })
    Department selectByPrimaryKey(Integer dno);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Select({
        "select",
        "dno, dname, dmanagerno, dmanagername",
        "from department"
    })
    @Results({
        @Result(column="dno", property="dno", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="dname", property="dname", jdbcType=JdbcType.VARCHAR),
        @Result(column="dmanagerno", property="dmanagerno", jdbcType=JdbcType.INTEGER),
        @Result(column="dmanagername", property="dmanagername", jdbcType=JdbcType.VARCHAR)
    })
    List<Department> selectAll();

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Update({
        "update department",
        "set dname = #{dname,jdbcType=VARCHAR},",
          "dmanagerno = #{dmanagerno,jdbcType=INTEGER},",
          "dmanagername = #{dmanagername,jdbcType=VARCHAR}",
        "where dno = #{dno,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Department row);
}