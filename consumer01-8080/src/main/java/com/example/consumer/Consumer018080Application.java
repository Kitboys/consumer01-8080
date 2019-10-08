package com.example.consumer;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients("com.example.consumer.openfeignService")
public class Consumer018080Application {

    public static void main(String[] args) {
        SpringApplication.run(Consumer018080Application.class, args);
    }


    @Bean
    public IRule loadBalanceRule() {
        return new RandomRule();
    }
}
