package com.github.nbyl.shoppy.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
@EnableEurekaClient
@EnableHystrixDashboard
@EnableTurbine
public class Application {

    public static void main(String[] args) {
        new SpringApplication(Application.class).run(args);
    }
}
