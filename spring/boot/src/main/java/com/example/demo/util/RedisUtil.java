package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate<String, String> redis;


    /**
     * 保存String值(365天)
     *
     * @param key   键
     * @param value 值
     */
    public void setString(String key, String value) {
        saveString(key, value, 365, TimeUnit.DAYS);
    }

    /**
     * 保存String值
     *
     * @param key     键
     * @param value   值
     * @param timeOut 过期时间(秒)
     */
    public void saveString(String key, String value, long timeOut) {
        saveString(key, value, timeOut, TimeUnit.SECONDS);
    }

    /**
     * 保存String值
     *
     * @param key      键
     * @param value    值
     * @param timeOut  过期时间
     * @param timeUnit 过期时间单位
     */
    public void saveString(String key, String value, long timeOut, TimeUnit timeUnit) {
        redis.opsForValue().set(key, value, timeOut, timeUnit);
    }

    public String findString(String key) {
        return redis.opsForValue().get(key);
    }

    public boolean delete(String key) {
        return redis.delete(key);
    }
}
