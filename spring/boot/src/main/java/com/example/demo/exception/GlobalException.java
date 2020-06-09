package com.example.demo.exception;

public class GlobalException extends Exception {
    private String code;

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(String code, String message) {
        super(message);
        this.code = code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
