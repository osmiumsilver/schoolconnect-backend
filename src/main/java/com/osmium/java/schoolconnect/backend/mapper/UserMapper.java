package com.osmium.java.schoolconnect.backend.mapper;

import com.osmium.java.schoolconnect.backend.entity.SysUser;
import com.osmium.java.schoolconnect.backend.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface UserMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Insert({
        "insert into user (userno, clno, ",
        "sex, idnumber, realname, ",
        "email, phone, address, ",
        "qq, `role`, `status`, ",
        "createtime)",
        "values (#{userno,jdbcType=INTEGER}, #{clno,jdbcType=INTEGER}, ",
        "#{sex,jdbcType=TINYINT}, #{idnumber,jdbcType=VARCHAR}, #{realname,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{qq,jdbcType=VARCHAR}, #{role,jdbcType=TINYINT}, #{status,jdbcType=TINYINT}, ",
        "#{createtime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(User row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Select({
        "select",
        "id, userno, clno, sex, idnumber, realname, email, phone, address, qq, `role`, ",
        "`status`, createtime",
        "from user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="userno", property="userno", jdbcType=JdbcType.INTEGER),
        @Result(column="clno", property="clno", jdbcType=JdbcType.INTEGER),
        @Result(column="sex", property="sex", jdbcType=JdbcType.TINYINT),
        @Result(column="idnumber", property="idnumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="qq", property="qq", jdbcType=JdbcType.VARCHAR),
        @Result(column="role", property="role", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP)
    })
    User selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Select({
        "select",
        "id, userno, clno, sex, idnumber, realname, email, phone, address, qq, `role`, ",
        "`status`, createtime",
        "from user"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="userno", property="userno", jdbcType=JdbcType.INTEGER),
        @Result(column="clno", property="clno", jdbcType=JdbcType.INTEGER),
        @Result(column="sex", property="sex", jdbcType=JdbcType.TINYINT),
        @Result(column="idnumber", property="idnumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="qq", property="qq", jdbcType=JdbcType.VARCHAR),
        @Result(column="role", property="role", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<User> selectAll();

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Update({
        "update user",
        "set userno = #{userno,jdbcType=INTEGER},",
          "clno = #{clno,jdbcType=INTEGER},",
          "sex = #{sex,jdbcType=TINYINT},",
          "idnumber = #{idnumber,jdbcType=VARCHAR},",
          "realname = #{realname,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "qq = #{qq,jdbcType=VARCHAR},",
          "`role` = #{role,jdbcType=TINYINT},",
          "`status` = #{status,jdbcType=TINYINT},",
          "createtime = #{createtime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(User row);



    int deleteByPrimaryKey(String username);
}