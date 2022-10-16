package backend;


import com.osmium.schoolconnect.backend.entity.Clazz;
import com.osmium.schoolconnect.backend.mapper.ClazzMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * @Author
 * @Date 2022/9/30
 * @Description
 */

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MybatisPlusTest {

    @Autowired
    private ClazzMapper clazzMapper;

    @Test
    void testSelect() throws Exception {
        System.out.println(("----- selectAll method test ------"));
        List<Clazz> clazzList = clazzMapper.selectClassList(null);
        Assertions.assertEquals(1, clazzList.size());
        clazzList.forEach(System.out::println);
    }
}
