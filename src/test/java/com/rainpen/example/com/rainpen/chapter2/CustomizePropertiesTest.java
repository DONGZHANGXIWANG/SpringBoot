package com.rainpen.example.com.rainpen.chapter2;

import com.rainpen.example.DdspringbootApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/4/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DdspringbootApplication.class)
public class CustomizePropertiesTest {

    @Autowired
    private CustomizeProperties customizeProperties;

    @Test
    public void test() throws Exception {
        Assert.assertEquals(customizeProperties.getName(), "rainpenlai");
        Assert.assertEquals(customizeProperties.getHight(), "183");
        System.out.println(customizeProperties.getDesc());

    }
}