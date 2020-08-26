package com.example.web.repository.impl;

import com.example.web.entity.LogEntity;
import com.example.web.repository.ILogMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class LogMongoRepository implements ILogMongoRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insertOne(LogEntity logEntity) {
        mongoTemplate.save(logEntity);
    }
}
