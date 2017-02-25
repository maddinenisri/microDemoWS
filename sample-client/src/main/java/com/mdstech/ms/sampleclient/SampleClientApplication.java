package com.mdstech.ms.sampleclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Srini on 2/20/17.
 */
@SpringBootApplication
@EnableEurekaClient
public class SampleClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleClientApplication.class, args);
    }
}
