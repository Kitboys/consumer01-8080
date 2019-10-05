package com.example.provider018081;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Provider018082Application {

    public static void main(String[] args) {
        SpringApplication.run(Provider018082Application.class, args);
    }

}
