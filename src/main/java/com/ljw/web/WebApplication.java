package com.ljw.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by Administrator on 2017/4/1 0001.
 */
@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer{

    @Override
    public SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(WebApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }
}
