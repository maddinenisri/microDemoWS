package com.mdstech.feign.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by Srini on 2/24/17.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignIntegrationApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignIntegrationApplication.class);
    }
}
