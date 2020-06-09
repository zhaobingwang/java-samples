package com.example.demo.service;

import com.example.demo.model.UserDto;
import com.example.demo.model.args.UserParam;

import java.util.List;

public interface IUserService {
    /**
     * 查找所有用户
     *
     * @param param 查询参数
     * @return
     */
    List<UserDto> findUsers(UserParam param);
}
