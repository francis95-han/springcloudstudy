/*
 * Copyright (c) 2018. zhangbohan.dell@gmail.com ,All Rights Reserved
 *
 */

package xyz.zhangbohan.ribbonconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import xyz.zhangbohan.ribbonconsumer.service.impl.HelloService;

/**
 * file encoding: utf-8
 * Function :
 * Create : 2018/10/12 10:15
 *
 * @author : zhangbohan.dell@gmail.com
 * @version : 1.0
 */
@RestController
public class ConsumerController {
    private final
    RestTemplate restTemplate;

    private final
    HelloService helloService;

    @Autowired
    public ConsumerController(RestTemplate restTemplate, HelloService helloService) {
        this.restTemplate = restTemplate;
        this.helloService = helloService;
    }

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
    }

    @RequestMapping(value = "/ribbon-consumer-hello-service", method = RequestMethod.GET)
    public String helloConsumerByHelloService() {
        return helloService.helloService();
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {

        return "Hello World";
    }
}
