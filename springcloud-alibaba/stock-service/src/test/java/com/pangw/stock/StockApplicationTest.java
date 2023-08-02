package com.pangw.stock;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(classes = StockApplication.class)
@EnableDiscoveryClient
public class StockApplicationTest {


    @Autowired
    private RestTemplate restTemplate;

    @Test
    void requestService(){

        String s = restTemplate.getForObject("http://user-service/user/1", String.class);
        Assertions.assertNotNull(s);
        Assertions.assertEquals("user-1", s);
    }



}
