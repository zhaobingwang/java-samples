package com.example.demo.util;

import com.example.demo.DemoApplication;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class RedisUtilTests {

    private final static String KEY_STRING = "test_string";
    @Autowired
    RedisUtil redisUtil;

    @Before
    public void setUp() {

    }

    @After
    public void cleanUp() {
        redisUtil.delete(KEY_STRING);
    }

    @Test
    public void setString1() {
        String val = "test";
        redisUtil.setString(KEY_STRING, val);
        String result = redisUtil.findString(KEY_STRING);
        Assert.assertEquals(val, result);
    }
}
