package com.osmium.java.schoolconnect.backend;
import com.osmium.java.schoolconnect.backend.entity.Clazz;
import com.osmium.java.schoolconnect.backend.mapper.ClazzMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * @Author
 * @Date 2022/9/30
 * @Description
 */

public class MybatisPlusTest {

    @Autowired
    private ClazzMapper TestMapper;

    @Test
    void testAssertConnectionPool() throws Exception {
        Clazz clazz = new Clazz();
        TestMapper.insert(clazz);
        assertThat(clazz.getClassName()).isNotNull();
    }
}
