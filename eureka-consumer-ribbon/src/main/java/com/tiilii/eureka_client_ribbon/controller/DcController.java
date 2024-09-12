package com.tiilii.eureka_client_ribbon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class DcController {
	private final Logger logger = LoggerFactory.getLogger(DcController.class);

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String dc() {
    	logger.info("===call eureka-consumer-ribbon===");
    	return restTemplate.getForEntity("http://eureka-client/dc", String.class).getBody();
    }

}