package com.example.demo.exception;

public class GlobalException extends Exception {
    private int code;

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(int code, String message) {
        super(message);
        this.code = code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
