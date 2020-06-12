package com.example.demo.snippets.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisSnippets {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void addString(String key, String value) {
        int expiredTime = 60;
        TimeUnit expiredTimeUnit = TimeUnit.SECONDS;
        addString(key, value, expiredTime, expiredTimeUnit);
    }

    public void addString(String key, String value, int expiredTime, TimeUnit expiredTimeUnit) {
        redisTemplate.opsForValue().set(key, value, expiredTime, expiredTimeUnit);
    }

    public String getString(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public boolean delete(String key) {
        return redisTemplate.delete(key);
    }
}