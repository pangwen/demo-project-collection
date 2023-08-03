package com.pangw.sharding.config;


import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PageHelperConfig {

    @Bean
    public PageHelper pageHelper(){
        return new PageHelper();
    }
}
