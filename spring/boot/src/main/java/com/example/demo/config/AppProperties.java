package com.example.demo.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class AppProperties {
    @Value("${com.app.name}")
    private String name;
    @Value("${com.app.description}")
    private String description;
}
