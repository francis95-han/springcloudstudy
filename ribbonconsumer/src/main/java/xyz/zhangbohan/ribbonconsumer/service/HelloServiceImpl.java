/*
 * Copyright (c) 2018. zhangbohan.dell@gmail.com ,All Rights Reserved
 *
 */

package xyz.zhangbohan.ribbonconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import xyz.zhangbohan.ribbonconsumer.service.impl.HelloService;

/**
 * file encoding: utf-8
 * Function :
 * Create : 2018/10/13 11:11
 *
 * @author : zhangbohan.dell@gmail.com
 * @version : 1.0
 */
@Service
public class HelloServiceImpl implements HelloService {
    private final
    RestTemplate restTemplate;

    @Autowired
    public HelloServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService() {
        return restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
    }

    public String helloFallback() {
        return "error";
    }
}