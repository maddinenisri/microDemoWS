package com.mdstech.feign.app.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Srini on 2/24/17.
 */
@FeignClient("sample-client")
public interface SampleClientEndpoint {

    @RequestMapping("/message")
    String message();
}
