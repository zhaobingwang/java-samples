package com.example.demo.webapi.impl;

import com.example.demo.exception.BusinessException;
import com.example.demo.model.UserDto;
import com.example.demo.model.args.UserParam;
import com.example.demo.service.impl.UserService;
import com.example.demo.webapi.IUser;
import com.example.demo.wrapper.RequestWrapper;
import com.example.demo.wrapper.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class User implements IUser {

    @Autowired
    private UserService userService;

    @Override
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseWrapper<List<UserDto>> userInfo(@RequestBody RequestWrapper<UserParam> args) throws Exception {
        List<UserDto> dtos = userService.findUsers(args.getArgs());
//        throw new Exception("aaaa");
        return new ResponseWrapper<>(dtos);
    }
}
