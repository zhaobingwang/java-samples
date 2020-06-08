package com.example.demo.repository;

import com.example.demo.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void addUser() {
//        userRepository.save(User.builder()
//                .name("测试A")
//                .password("a123456")
//                .email("testa@email.com")
//                .regTime(Instant.now().toEpochMilli())
//                .build()
//        );
//        userRepository.save(User.builder()
//                .name("测试B")
//                .password("b123456")
//                .email("testb@email.com")
//                .regTime(Instant.now().toEpochMilli())
//                .build()
//        );
//        Assert.assertEquals(2, userRepository.findAll().size());
    }

    @Test
    public void getUser(){

    }
}
