package com.imooc.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangguanghui
 */
@SpringBootApplication(scanBasePackages = "com.imooc")
@MapperScan("com.imooc.persistence.dao")
public class FirstDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstDemoApplication.class, args);
    }
}
