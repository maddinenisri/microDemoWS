package com.mdstech.feign.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Srini on 2/24/17.
 */
@RestController
public class SampleClientIntegrationController {

    @Autowired
    private SampleClientEndpoint sampleClientEndpoint;

    @GetMapping
    public String getMessageFromSampleEndpoint() {
        return sampleClientEndpoint.message();
    }
}
