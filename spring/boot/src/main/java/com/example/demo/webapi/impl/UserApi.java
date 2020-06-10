package com.example.demo.webapi.impl;

import com.example.demo.constants.ApiCode;
import com.example.demo.model.UserDto;
import com.example.demo.model.args.UserParam;
import com.example.demo.service.impl.UserService;
import com.example.demo.webapi.IUserApi;
import com.example.demo.wrapper.RequestWrapper;
import com.example.demo.wrapper.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserApi implements IUserApi {

    @Autowired
    private UserService userService;

    @Override
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseWrapper<List<UserDto>> userInfo(@RequestBody RequestWrapper<UserParam> args) throws Exception {
        List<UserDto> dtos = userService.findUsers(args.getArgs());
//        throw new Exception("aaaa");
        return new ResponseWrapper<>(dtos);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseWrapper<UserDto> getUserInfoById(@PathVariable long id) {
        Optional<UserDto> dto = userService.findById(id);
        if (dto.isPresent()) {
            return new ResponseWrapper<>(dto.get());
        }
        return new ResponseWrapper<>(
                ApiCode.USER_NOT_FOUND, ApiCode.USER_NOT_FOUND_MESSAGE, null);
    }
}
