package com.github.nbyl.shoppy.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
@EnableEurekaClient
@EnableHystrix
public class Application {

    public static void main(String[] args) {
        new SpringApplication(Application.class).run(args);
    }
}
