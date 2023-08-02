package com.pangw.simple.controller;

import com.pangw.simple.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;


@RestController
@RequestMapping("hello")
public class HelloCtrl {

    private final HelloService helloService;


    public HelloCtrl(HelloService helloService){
        this.helloService = helloService;
    }

    @PostConstruct
    public void init(){
        System.out.println("hello controller post construct.");
    }


    @GetMapping
    public String hello(String msg){
        return helloService.hello(msg);
    }
}
