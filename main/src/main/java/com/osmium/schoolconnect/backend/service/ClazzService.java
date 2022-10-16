package com.osmium.schoolconnect.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.osmium.schoolconnect.backend.entity.Clazz;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author
 * @date 2022/3/29
 * @apinote
 */

public interface ClazzService extends IService<Clazz> {
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
     * 批量删除班级
     *
     * @param clnos 需要删除的班级主键集合
     * @return 结果
     */
    public int deleteClassByClnos(String clnos);

    /**
     * 删除班级信息
     *
     * @param clno 班级主键
     * @return 结果
     */
    public int deleteClassByClno(String clno);
}


