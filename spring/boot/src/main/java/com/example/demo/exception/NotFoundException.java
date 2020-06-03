package com.example.demo.exception;

public class NotFoundException extends GlobalException {
    public NotFoundException(int code, String message) {
        super(code, message);
    }
}
