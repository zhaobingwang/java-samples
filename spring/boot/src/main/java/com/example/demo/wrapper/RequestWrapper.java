package com.example.demo.wrapper;

import java.io.Serializable;

public class RequestWrapper<T> implements Serializable {
    RequestWrapper() {
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
