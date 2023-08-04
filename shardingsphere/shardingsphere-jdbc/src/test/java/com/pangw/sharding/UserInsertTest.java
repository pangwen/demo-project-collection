package com.pangw.sharding;


import com.pangw.sharding.entity.UserEntity;
import com.pangw.sharding.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = ShardingJdbcApplication.class)
class UserInsertTest {

    @Autowired
    private UserService userService;


    @Test
    void test() {
        int batch = 1000;
        List<UserEntity> users = new ArrayList<>(1500);
        for (int i = 347601; i < 10_000_000; i++) {

            UserEntity userEntity = new UserEntity();
            userEntity.randomUser();
            userEntity.setId(i + 1L);

            users.add(userEntity);

            if ( i % batch == 0) {
                userService.batchInsert(users);
                users.clear();
            }
        }

        if (!users.isEmpty()) {
            userService.batchInsert(users);
        }
    }

    @Test
    void testInsertOneByOne(){
        for (int i = 0; i < 10_000_000; i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.randomUser();
            userEntity.setId(i + 1L);

            userService.insert(userEntity);
        }
    }
}
