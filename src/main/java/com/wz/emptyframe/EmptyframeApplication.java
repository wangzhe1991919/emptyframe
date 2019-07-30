package com.wz.emptyframe;

import org.apache.commons.lang3.ArrayUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

/**
 * @author wangzhe1991919
 */
@SpringBootApplication
@MapperScan("com.wz.emptyframe.*")
public class EmptyframeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmptyframeApplication.class, args);
    }
}
