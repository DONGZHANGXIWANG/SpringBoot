package com.rainpen.example.com.rainpen.redis;

import com.rainpen.example.DdspringbootApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * redis测试
 * @author laiyup-S9644
 * @date 2018年06月07日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DdspringbootApplication.class)
public class ApplicationTests {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {

        // 保存字符串
        stringRedisTemplate.opsForValue().set("caonima", "nimade");
        Assert.assertEquals("nimade", stringRedisTemplate.opsForValue().get("caonima"));

    }


}
