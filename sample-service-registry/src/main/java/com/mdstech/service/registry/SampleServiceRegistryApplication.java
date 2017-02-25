package com.mdstech.service.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Srini on 2/24/17.
 */
@SpringBootApplication
@EnableEurekaServer
public class SampleServiceRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleServiceRegistryApplication.class, args);
    }
}
