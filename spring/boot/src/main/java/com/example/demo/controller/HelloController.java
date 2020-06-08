package com.example.demo.controller;

import com.example.demo.config.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {
    private final String KEY_TEST = "key_test";
    @Autowired
    private AppProperties appProperties;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public String hello() {
        System.out.println(appProperties.getDescription());
        logger.info("Interface hello is accessed");
        String result = "hello";
        if (redisTemplate.opsForValue().get(KEY_TEST) == null) {
            redisTemplate.opsForValue().set(KEY_TEST, result + " from redis", 1, TimeUnit.MINUTES);
        } else {
            result = redisTemplate.opsForValue().get(KEY_TEST);
        }
        return result;
    }
}
