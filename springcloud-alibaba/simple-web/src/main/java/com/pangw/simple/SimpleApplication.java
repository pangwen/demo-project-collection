package com.pangw.simple;


import com.pangw.simple.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimpleApplication {

    public static final Logger log = LoggerFactory.getLogger(SimpleApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SimpleApplication.class, args);
    }


    @Bean
    public HelloService helloService(){

        log.info("instantiate helloService...");
        return new HelloService();
    }
}
