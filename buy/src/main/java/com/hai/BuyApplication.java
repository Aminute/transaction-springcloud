package com.hai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hai.repository")
public class BuyApplication {
    public static void main(String[] args) {
        SpringApplication.run(BuyApplication.class,args);
    }
}
