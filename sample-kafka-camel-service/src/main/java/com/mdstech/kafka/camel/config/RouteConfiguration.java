package com.mdstech.kafka.camel.config;

import org.apache.camel.Endpoint;
import org.apache.camel.component.kafka.KafkaEndpoint;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * Created by Srini on 3/12/17.
 */
@Component
public class RouteConfiguration {

    @Value("${service.kafka.host}")
    private String kafkaHost;

    @Value("${service.kafka.port}")
    private String kafkaPort;

    @Value("${service.kafka.topic}")
    private String kafkaTopic;

    @Value("${service.kafka.groupId}")
    private String groupId;

    @Value("${service.kafka.offset}")
    private String offset;


    @Bean
    public Endpoint testEndPoint() {
        String endpointUri = "kafka://" + kafkaHost + ":" + kafkaPort;
        KafkaEndpoint endpoint = new DefaultCamelContext().getEndpoint(endpointUri, KafkaEndpoint.class);
        endpoint.getConfiguration().setTopic(kafkaTopic);
        endpoint.getConfiguration().setKeyDeserializer("org.apache.kafka.common.serialization.StringDeserializer");
        endpoint.getConfiguration().setValueDeserializer("org.apache.kafka.common.serialization.StringDeserializer");
        endpoint.getConfiguration().setAutoOffsetReset(offset);
        endpoint.getConfiguration().setGroupId(groupId);
        return endpoint;
    }
}
