package com.osmium.java.schoolconnect.backend;

import com.osmium.java.schoolconnect.backend.config.WebConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * @Author
 * @Date 2022/9/27
 * @Description
 */

@SpringBootTest
@ContextConfiguration(
        classes = {WebConfig.class},loader = AnnotationConfigContextLoader.class)
class SpringContextIntegrationTest
{
    @Test
    void contextLoads()
    {}

}
