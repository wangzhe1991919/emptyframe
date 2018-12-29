package com.wz.emptyframe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.wz.emptyframe.*")
public class EmptyframeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmptyframeApplication.class, args);
    }
}
