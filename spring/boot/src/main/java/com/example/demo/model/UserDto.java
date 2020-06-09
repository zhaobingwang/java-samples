package com.example.demo.model;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UserDto {
    private String name;
    private String email;
}
