package com.example.demo.repository;

import com.example.demo.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
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
//        userRepository.save(User.builder()
//                .name("测试C")
//                .password("c123456")
//                .email("testc@email.com")
//                .regTime(Instant.now().toEpochMilli())
//                .build()
//        );
//        userRepository.save(User.builder()
//                .name("测试D")
//                .password("d123456")
//                .email("testd@email.com")
//                .regTime(Instant.now().toEpochMilli())
//                .build()
//        );
//        userRepository.save(User.builder()
//                .name("测试E")
//                .password("e123456")
//                .email("teste@email.com")
//                .regTime(Instant.now().toEpochMilli())
//                .build()
//        );
        userRepository.save(User.builder()
                .name("测试Z")
                .password("z123456")
                .email("testz@email.com")
                .regTime(Instant.now().toEpochMilli())
                .build()
        );
        Assert.assertEquals(1, userRepository.findByName("测试Z").size());
    }

    @Test
    @Transactional
    public void findByNameBySql() {
        userRepository.save(User.builder()
                .name("测试Z")
                .password("z123456")
                .email("testz@email.com")
                .regTime(Instant.now().toEpochMilli())
                .build()
        );
        List<User> users = userRepository.findByNameBySql("测试Z");
        Assert.assertEquals(1, users.size());
    }
}
