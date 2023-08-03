package com.pangw.sharding.service;


import com.pangw.sharding.entity.UserEntity;
import com.pangw.sharding.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {


    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void insert(){
        int batch = 200;
        List<UserEntity> users = new ArrayList<>(300);
        for (int i = 0; i < 10_000_000; i++) {

            UserEntity userEntity = new UserEntity();
            userEntity.randomUser();
            userEntity.setId(i + 1L);

            users.add(userEntity);

            if (i > 0 && i % batch == 0) {
                userMapper.insertBatch(users);
                users.clear();
            }

        }
    }

}
