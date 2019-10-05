package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients("com.example.consumer.openfeignService")
public class Consumer028079Application {

    public static void main(String[] args) {
        SpringApplication.run(Consumer028079Application.class, args);
    }

}
