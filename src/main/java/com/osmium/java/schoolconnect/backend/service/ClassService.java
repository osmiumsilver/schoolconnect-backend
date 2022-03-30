package com.osmium.java.schoolconnect.backend.service;

import com.osmium.java.schoolconnect.backend.entity.Class;

import java.util.List;

/**
 * @author
 * @date 2022/3/29
 * @apinote
 */
public interface ClassService {
    List<Class> queryAllClass();
    void insertClass(Integer clno, String clname, Integer dno);
    void deleteClass(Integer clno);
    void updateClass(Integer new_clno, String clname, Integer dno,Integer clno);
}


