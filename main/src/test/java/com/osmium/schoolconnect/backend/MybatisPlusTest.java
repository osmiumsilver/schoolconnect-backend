package com.osmium.schoolconnect.backend;


import com.osmium.schoolconnect.backend.entity.Clazz;
import com.osmium.schoolconnect.backend.entity.CourseInfo;
import com.osmium.schoolconnect.backend.entity.Employee;
import com.osmium.schoolconnect.backend.mapper.ClazzMapper;
import com.osmium.schoolconnect.backend.mapper.CourseMapper;
import com.osmium.schoolconnect.backend.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


/**
 * @Author
 * @Date 2022/9/30
 * @Description
 */

@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    void contextLoads() throws Exception {
        System.out.println(("----- selectAll method test ------"));
        List<Clazz> clazzList = clazzMapper.selectList(null);
        clazzList.forEach(System.out::println);


        List<CourseInfo> courseList = courseMapper.selectList(null);
        courseList.forEach(System.out::println);

        List<Employee> employeeList = employeeMapper.selectList(null);
        employeeList.forEach(System.out::println);
    }
}
