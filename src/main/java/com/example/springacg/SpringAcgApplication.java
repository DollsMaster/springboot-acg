package com.example.springacg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springacg.mapper")
public class SpringAcgApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAcgApplication.class, args);
    }

}
