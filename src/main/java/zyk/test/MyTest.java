package zyk.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Component
public class MyTest {

    Logger logger = LoggerFactory.getLogger(MyTest.class);
    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void test(){
        String value = (String) redisTemplate.opsForValue().get("test:set");
        logger.info("aa = " + value);

    }

}
