package com.hzy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Springboot10RedisApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        // redisTemplate 操作不同的数据类型
        // opsForValue 操作字符串，类似于String
        // opsForList 操作list，类似于List
        // 等等...
        redisTemplate.opsForValue().set("k1","v1");
        System.out.println(redisTemplate.opsForValue().get("k1"));
    }

}
