package com.mdstech.sample.camel.config;

import org.apache.camel.Endpoint;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Srini on 3/12/17.
 */
@Configuration
public class KafkaCamelRouteBuilder extends RouteBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaCamelRouteBuilder.class);

    @Autowired
    Endpoint testEndPoint;

    @Override
    public void configure() throws Exception {

        from(testEndPoint)
                .process(exchange -> {
                    System.out.println("Received Message");
                    LOGGER.info("------------------ BEGIN OF RECEIVED MESSAGE --------------");
                    LOGGER.info("Hello " + exchange.getIn().getBody().toString() + "!");
                    LOGGER.info("Message ID " + exchange.getIn().getHeader(KafkaConstants.KEY));
                    LOGGER.info("------------------- END OF RECEIVED MESSAGE ---------------");
                })
                .end()
                .setId("productionRoute");
    }
}
