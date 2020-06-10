package com.example.demo.webapi;

import com.example.demo.model.UserDto;
import com.example.demo.model.args.UserParam;
import com.example.demo.wrapper.RequestWrapper;
import com.example.demo.wrapper.ResponseWrapper;

import java.util.List;

public interface IUserApi {
    ResponseWrapper<List<UserDto>> userInfo(RequestWrapper<UserParam> args) throws Exception;
}
