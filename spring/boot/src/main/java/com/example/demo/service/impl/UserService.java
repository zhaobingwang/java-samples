package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.model.UserDto;
import com.example.demo.model.args.UserParam;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("userServices")
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> findUsers(UserParam param) {
        List<User> entities = userRepository.findByName(param.getName());
        List<UserDto> dtos = new ArrayList<>();
        for (User entity : entities) {
            UserDto dto = new UserDto();
            dto.setName(entity.getName());
            dto.setEmail(entity.getEmail());
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public Optional<UserDto> findById(long id) {
        Optional<User> entity = userRepository.findById(id);
        UserDto dto = null;
        if (entity.isPresent()) {
            dto = new UserDto();
            User notNullUser = entity.get();
            dto.setName(notNullUser.getName());
            dto.setEmail(notNullUser.getEmail());
        }
        return Optional.ofNullable(dto);
    }
}
