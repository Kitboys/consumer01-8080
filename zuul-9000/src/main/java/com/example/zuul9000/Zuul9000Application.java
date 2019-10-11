package com.example.zuul9000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy //开启zuul 代理模式
@SpringBootApplication
public class Zuul9000Application {

    public static void main(String[] args) {
        SpringApplication.run(Zuul9000Application.class, args);
    }

}
