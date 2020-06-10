package com.example.demo.wrapper;

import com.alibaba.fastjson.annotation.JSONField;
import com.example.demo.constants.ApiCode;

import java.io.Serializable;

public class ResponseWrapper<T> implements Serializable {

    @JSONField(name = "errcode", ordinal = 1)
    private String errorCode = ApiCode.OK;

    @JSONField(name = "errmsg", ordinal = 2)
    private String errorMessage;

    @JSONField(name = "content", ordinal = 3)
    private T content;

    public ResponseWrapper() {
        super();
    }

    public ResponseWrapper(T content) {
        super();
        this.errorMessage = ApiCode.OK_MESSAGE;
        this.content = content;
    }

    public ResponseWrapper(String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ResponseWrapper(String errorCode, String errorMessage, T content) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
