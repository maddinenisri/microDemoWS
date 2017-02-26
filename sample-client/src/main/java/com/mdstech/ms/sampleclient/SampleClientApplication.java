package com.mdstech.ms.sampleclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Srini on 2/20/17.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SampleClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleClientApplication.class, args);
    }
}
