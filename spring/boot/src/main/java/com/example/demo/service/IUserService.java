package com.example.demo.service;

import com.example.demo.model.UserDto;
import com.example.demo.model.args.UserParam;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    /**
     * 查找所有用户
     *
     * @param param 查询参数
     * @return
     */
    List<UserDto> findUsers(UserParam param);

    /**
     * 查找符合条件的一个用户
     *
     * @param id 主键ID
     * @return
     */
    Optional<UserDto> findById(long id);
}
