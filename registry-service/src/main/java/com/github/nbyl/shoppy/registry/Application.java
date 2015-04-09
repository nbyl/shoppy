package com.github.nbyl.shoppy.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
@EnableEurekaServer
public class Application {

    public static void main(String[] args) {
        new SpringApplication(Application.class).run(args);
    }
}
