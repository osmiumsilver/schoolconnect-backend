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
    public Clazz selectClassByClno(String clno);



    /**
     * 查询班级列表
     *
     * @param clazz 班级
     * @return 班级集合
     */
    public List<Clazz> selectClassList(Clazz clazz);



    /**
     * 新增班级
     *
     * @param clazz 班级
     * @return 结果
     */
    public int insertClass(Clazz clazz);



    /**
     * 修改班级
     *
     * @param clazz 班级
     * @return 结果
     */
    public int updateClass(Clazz clazz);

    /**
     * 删除班级
     *
     * @param clno 班级主键
     * @return 结果
     */
    public int deleteClassByClno(String clno);

    /**
     * 批量删除班级
     *
     * @param clnos 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClassByClnos(String[] clnos);
}