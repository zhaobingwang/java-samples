package com.example.demo.controller;

import com.example.demo.controller.viewmodel.UserViewModel;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("")
    public List<UserViewModel> getAllUser(@RequestParam("pageindex") Integer pageIndex, @RequestParam("pagesize") Integer pageSize,
                                          @RequestParam("name")  String name) {
        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (!StringUtils.isEmpty(name)) {
                    Predicate likeNickName = criteriaBuilder.like(root.get("name").as(String.class), "%" + name + "%");
                    predicates.add(likeNickName);
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };
        Sort sort = Sort.by(Sort.Direction.DESC, "name");
        Pageable pageable = PageRequest.of(pageIndex - 1, pageSize, sort); // 前端从1开始，jpa从0开始
//        List<User> users = userRepository.findAll(specification, pageable);
        Page<User> users = userRepository.findAll(specification, pageable);
//        return  users;

        List<UserViewModel> vm = new ArrayList<>();
        for (User user : users.getContent()) {
            vm.add(UserViewModel.builder()
                    .name(user.getName())
                    .email(user.getEmail())
                    .id(user.getId())
                    .identityId(user.getIdentityId())
                    .password(user.getPassword())
                    .regTime(timestampToString(user.getRegTime(), Locale.CHINA, "Asia/Shanghai"))
                    .build());
        }
        return vm;
    }

    static String timestampToString(long epochMilli, Locale lo, String zoneId) {
        Instant ins = Instant.ofEpochMilli(epochMilli);
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return f.withLocale(lo).format(ZonedDateTime.ofInstant(ins, ZoneId.of(zoneId)));
    }
}
