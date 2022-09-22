package com.osmium.java.schoolconnect.backend.mapper;

import com.osmium.java.schoolconnect.backend.entity.Clazz;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ClazzMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Delete({
        "delete from class",
        "where clno = #{clno,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer clno);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Insert({
        "insert into class (clno, clname, ",
        "dno, tname, tno, ",
        "iname, ino)",
        "values (#{clno,jdbcType=INTEGER}, #{clname,jdbcType=VARCHAR}, ",
        "#{dno,jdbcType=INTEGER}, #{tname,jdbcType=VARCHAR}, #{tno,jdbcType=INTEGER}, ",
        "#{iname,jdbcType=VARCHAR}, #{ino,jdbcType=INTEGER})"
    })
    int insert(Clazz row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Select({
        "select",
        "clno, clname, dno, tname, tno, iname, ino",
        "from class",
        "where clno = #{clno,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="clno", property="clno", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="clname", property="clname", jdbcType=JdbcType.VARCHAR),
        @Result(column="dno", property="dno", jdbcType=JdbcType.INTEGER),
        @Result(column="tname", property="tname", jdbcType=JdbcType.VARCHAR),
        @Result(column="tno", property="tno", jdbcType=JdbcType.INTEGER),
        @Result(column="iname", property="iname", jdbcType=JdbcType.VARCHAR),
        @Result(column="ino", property="ino", jdbcType=JdbcType.INTEGER)
    })
    Clazz selectByPrimaryKey(Integer clno);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Select({
        "select",
        "clno, clname, dno, tname, tno, iname, ino",
        "from class"
    })
    @Results({
        @Result(column="clno", property="clno", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="clname", property="clname", jdbcType=JdbcType.VARCHAR),
        @Result(column="dno", property="dno", jdbcType=JdbcType.INTEGER),
        @Result(column="tname", property="tname", jdbcType=JdbcType.VARCHAR),
        @Result(column="tno", property="tno", jdbcType=JdbcType.INTEGER),
        @Result(column="iname", property="iname", jdbcType=JdbcType.VARCHAR),
        @Result(column="ino", property="ino", jdbcType=JdbcType.INTEGER)
    })
    List<Clazz> selectAll();

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Update({
        "update class",
        "set clname = #{clname,jdbcType=VARCHAR},",
          "dno = #{dno,jdbcType=INTEGER},",
          "tname = #{tname,jdbcType=VARCHAR},",
          "tno = #{tno,jdbcType=INTEGER},",
          "iname = #{iname,jdbcType=VARCHAR},",
          "ino = #{ino,jdbcType=INTEGER}",
        "where clno = #{clno,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Clazz row);



@Select("select * from class order by clno")
    List<Clazz> queryAllClass();

    @Delete("delete from class where clno= #{clno}")
    void deleteClass(Integer clno);

@Insert("insert into class values(#{clno},#{clname},#{dno})")
    void insertClass(Integer clno, String clname, Integer dno);

@Update("update class set clno = #{new_clno},clname = #{clname},dno = #{dno} where clno = #{clno}")
    void updateClass(Integer new_clno, String clname, Integer dno,Integer clno);
}