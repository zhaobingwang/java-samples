package com.example.web.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
@Document(collection = "log.exceptions")
public class LogEntity {
    private ObjectId Id;
    private String Code;
    private String ExType;
    private String Message;
    private String Details;
    private LocalDateTime LogTime;
}
