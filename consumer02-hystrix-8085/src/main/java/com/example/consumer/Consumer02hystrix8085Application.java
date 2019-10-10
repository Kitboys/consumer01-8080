package com.example.consumer;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableCircuitBreaker // 开启服务降级（熔断器， 实际上是提供者的熔断）
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients("com.example.consumer.openfeignService")
public class Consumer02hystrix8085Application {

    public static void main(String[] args) {
        SpringApplication.run(Consumer02hystrix8085Application.class, args);
    }


    @Bean
    public IRule loadBalanceRule() {
        return new RandomRule();
    }
}
