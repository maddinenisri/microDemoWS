package com.mdstech.sample.camel.controller;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Srini on 3/29/17.
 */
@RestController
public class MessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);
    @Autowired
    private CamelContext camelContext;

    @GetMapping("/publish/{message}")
    public String sendMessageToKafka(@PathVariable("message") String message) {
        LOGGER.debug("Received request to send message to kafka " + message);
        ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
        producerTemplate.sendBody("direct:start", message);
        LOGGER.debug("Completed request to send message to kafka " + message);
        return "Published message to Kafka";
    }
}
