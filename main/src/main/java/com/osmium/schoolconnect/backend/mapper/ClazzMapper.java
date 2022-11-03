package com.osmium.schoolconnect.backend.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.Clazz;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ClazzMapper extends BaseMapper<Clazz>  {


    /**
     * 查询班级
     *
     * @param clno 班级主键
     * @return 班级
     */
    Clazz selectClassByClno(String clno);



    /**
     * 查询班级列表
     *
     * @param clazz 班级
     * @return 班级集合
     */
    List<Clazz> selectClassList(Clazz clazz);



    /**
     * 新增班级
     *
     * @param clazz 班级
     * @return 结果
     */
    int insertClass(Clazz clazz);



    /**
     * 修改班级
     *
     * @param clazz 班级
     * @return 结果
     */
    int updateClass(Clazz clazz);

    /**
     * 删除班级
     *
     * @param clno 班级主键
     * @return 结果
     */
    int deleteClassByClno(String clno);

    /**
     * 批量删除班级
     *
     * @param clnos 需要删除的数据主键集合
     * @return 结果
     */
    int deleteClassByClnos(String[] clnos);
}