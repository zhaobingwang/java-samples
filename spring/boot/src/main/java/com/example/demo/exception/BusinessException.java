package com.example.demo.exception;

public class BusinessException extends GlobalException {
    public BusinessException(String code, String message) {
        super(code, message);
    }
}
