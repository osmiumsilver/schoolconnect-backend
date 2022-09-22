package com.osmium.java.schoolconnect.backend.service;


import com.osmium.java.schoolconnect.backend.entity.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author
 * @date 2022/3/29
 * @apinote
 */
public interface ClassService extends JpaRepository<Clazz,Long> {

}


