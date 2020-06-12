package com.example.demo.model.request;

import java.io.Serializable;


public class Request<T> implements Serializable {
    Request() {
        super();
    }

    private T args;

    public T getArgs() {
        return this.args;
    }

    public void setArgs(T args) {
        this.args = args;
    }
}

