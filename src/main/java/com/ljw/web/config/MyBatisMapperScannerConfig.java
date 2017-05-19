package com.ljw.web.config;

import com.ljw.web.annotation.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/4/5 0005.
 */
@Configuration
@AutoConfigureAfter(MyBatisConfig.class)//1
public class MyBatisMapperScannerConfig {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //可以结合自定义注解和包扫描，进行筛选
//        mapperScannerConfigurer.setAnnotationClass(Mapper.class);
        mapperScannerConfigurer.setBasePackage("com.ljw.web.dao");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapperScannerConfigurer;
    }
}
