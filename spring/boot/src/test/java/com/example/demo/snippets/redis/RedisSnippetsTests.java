package com.example.demo.snippets.redis;

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
public class RedisSnippetsTests {
    private final static String KEY_STRING = "test-string";
    @Autowired
    RedisSnippets redisSnippets;

    @Before
    public void setUp() {

    }

    @After
    public void cleanUp() {
        redisSnippets.delete(KEY_STRING);
    }

    @Test
    public void addString() {
        // arrange
        String val = "test";

        // act
        redisSnippets.addString(KEY_STRING, val);
        String result = redisSnippets.getString(KEY_STRING);

        // assert
        Assert.assertEquals(result, val);
    }
}
