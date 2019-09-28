package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Consumer018080Application {

    public static void main(String[] args) {
        SpringApplication.run(Consumer018080Application.class, args);
    }

}
