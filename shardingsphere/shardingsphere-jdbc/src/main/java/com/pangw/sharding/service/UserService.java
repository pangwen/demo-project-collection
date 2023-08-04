package com.pangw.sharding.service;


import com.pangw.sharding.entity.UserEntity;
import com.pangw.sharding.mapper.UserMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class UserService {


    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Transactional
    public void insert(UserEntity user){
        userMapper.insert(user);
    }

    @Transactional
    public void batchInsert(List<UserEntity> users){
//        if (Objects.nonNull(users) && !users.isEmpty()) {
//
//        }
        Optional.ofNullable(users).ifPresent(i -> i.forEach(this::insert));
    }

}
