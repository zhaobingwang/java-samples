package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findAll(Specification<User> spec, Pageable pageable);

    List<User> findByName(String name);


    @Query("select u from users u where u.name like %?1%")
    List<User> findByNameBySql(String name);

    List<User> findAllByName(String name, Pageable pageable);
}
