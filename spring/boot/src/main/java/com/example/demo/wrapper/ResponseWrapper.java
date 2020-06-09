package com.example.demo.wrapper;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class ResponseWrapper<T> implements Serializable {
    // 1: 成功，0: 失败
    private int code = 1;
    private String message;

    // 请求失败时才有的错误编码
    private String errorCode;

    // 请求响应内容
    @JSONField(name = "content")
    private T content;

    public ResponseWrapper() {
        super();
    }

    public ResponseWrapper(T content) {
        super();
        this.code = 1;
        this.message = "success";
        this.content = content;
    }

    public ResponseWrapper(int code, String message, String errorCode, T content) {
        super();
        this.code = code;
        this.message = message;
        this.errorCode = errorCode;
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
