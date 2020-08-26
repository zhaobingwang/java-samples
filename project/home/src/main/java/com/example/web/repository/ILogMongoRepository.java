package com.example.web.repository;

import com.example.web.entity.LogEntity;

public interface ILogMongoRepository {
    void insertOne(LogEntity logEntity);
}
