package com.example.demo.exception;

public class Result {
    /*
     * 错误码
     */
    private int code;

    /**
     * 错误内容
     */
    private String error;

    public Result(int code, String message) {
        this.code = code;
        this.error = message;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public enum ErrorCode {
        USER_NOT_FOUND(10001),
        USER_ALREADY_EXIST(10002),
        ;

        private int code;

        public int getCode() {
            return this.code;
        }

        ErrorCode(int code) {
        }
    }
}
