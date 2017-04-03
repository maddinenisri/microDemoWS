package com.mdstech.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

/**
 * Created by Srini on 4/1/17.
 */
@SpringBootApplication
@EnableNeo4jRepositories
public class SampleGraphDBApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleGraphDBApplication.class);
    }
}
