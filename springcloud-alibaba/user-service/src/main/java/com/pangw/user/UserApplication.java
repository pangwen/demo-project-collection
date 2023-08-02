package com.pangw.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableDiscoveryClient
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @RestController
    @RequestMapping("user")
    public static class UserCtrl {

        public final Map<String, String> users = new HashMap<>();

        private void init (){
            for (int i = 1; i < 5; i++) {
                users.put(String.valueOf(i), "user-" + i);
            }
        }

        public UserCtrl() {
            init();

        }

        @GetMapping("{id}")
        public String getUserById(@PathVariable String id){
            if (users.containsKey(id)) {
                return users.get(id);
            }
            return String.format("user %s dose not exist", id);
        }
    }
}
