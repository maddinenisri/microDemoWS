package com.mdstech.ms.sampleclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Srini on 2/20/17.
 */
@RefreshScope
@RestController
public class MessageController {

    @Value("${message: Unable to get from config server}")
    private String message;

    @GetMapping("/message")
    public String getMessage() {
        return this.message;
    }
}
