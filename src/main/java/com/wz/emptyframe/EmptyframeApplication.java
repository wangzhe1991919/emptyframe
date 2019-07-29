package com.wz.emptyframe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wz.emptyframe.*")
public class EmptyframeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmptyframeApplication.class, args);
    }
}
