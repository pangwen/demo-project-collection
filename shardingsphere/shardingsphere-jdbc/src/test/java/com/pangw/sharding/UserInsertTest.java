package com.pangw.sharding;


import com.pangw.sharding.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ShardingJdbcApplication.class)
public class UserInsertTest {

    @Autowired
    private UserService userService;


    @Test
    void test(){
        userService.insert();
    }
}
