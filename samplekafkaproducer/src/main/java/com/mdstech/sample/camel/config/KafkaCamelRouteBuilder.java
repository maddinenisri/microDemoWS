package com.mdstech.sample.camel.config;

import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Srini on 3/12/17.
 */
@Configuration
public class KafkaCamelRouteBuilder extends RouteBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaCamelRouteBuilder.class);

    @Produce(uri = "direct:start")
    private ProducerTemplate template;

    @Value("${service.kafka.host}")
    private String kafkaHost;

    @Value("${service.kafka.port}")
    private String kafkaPort;

    @Value("${service.kafka.topic}")
    private String kafkaTopic;

    @Value("${spring.cloud.stream.kafka.binder.zkNodes}")
    private String zkHost;

    @Value("${spring.cloud.stream.kafka.binder.brokers}")
    private String brokers;

    @Override
    public void configure() throws Exception {

        String endpoint = String.format("kafka:%s:%s?topic=%s", kafkaHost, kafkaPort, kafkaTopic);
        from("direct:start").process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                LOGGER.info("------------------ BEGIN OF RECEIVED MESSAGE --------------");
                exchange.getIn().setBody("Test Message from Camel Kafka Component Final",String.class);
                exchange.getIn().setHeader(KafkaConstants.PARTITION_KEY, 0);
                exchange.getIn().setHeader(KafkaConstants.KEY, "1");
                LOGGER.info("------------------- END OF RECEIVED MESSAGE ---------------");
            }
        }).to(endpoint);
//        from(testEndPoint)
//                .process(exchange -> {
//                    System.out.println("Received Message");
//                    LOGGER.info("------------------ BEGIN OF RECEIVED MESSAGE --------------");
//                    LOGGER.info("Hello " + exchange.getIn().getBody().toString() + "!");
//                    LOGGER.info("Message ID " + exchange.getIn().getHeader(KafkaConstants.KEY));
//                    LOGGER.info("------------------- END OF RECEIVED MESSAGE ---------------");
//                })
//                .end()
//                .setId("productionRoute");
    }
}
