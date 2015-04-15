package com.github.nbyl.shoppy.shoppinglist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
@EnableEurekaClient
public class Application {

    public static void main(String[] args) {
        new SpringApplication(Application.class).run(args);
    }
}
