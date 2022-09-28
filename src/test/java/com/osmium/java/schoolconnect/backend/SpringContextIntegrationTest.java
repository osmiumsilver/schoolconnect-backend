package com.osmium.java.schoolconnect.backend;

import com.osmium.java.schoolconnect.backend.config.PersistenceConfiguration;
import com.osmium.java.schoolconnect.backend.config.WebConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * @Author
 * @Date 2022/9/27
 * @Description
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {WebConfig.class, PersistenceConfiguration.class},loader = AnnotationConfigContextLoader.class)

public class SpringContextIntegrationTest
{
    @Test
    public void contextLoads()
    {}

}
