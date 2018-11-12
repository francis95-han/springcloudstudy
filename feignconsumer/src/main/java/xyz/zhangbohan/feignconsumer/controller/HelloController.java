/*
 * Copyright (c) 2018. zhangbohan.dell@gmail.com ,All Rights Reserved
 *
 */

package xyz.zhangbohan.feignconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.zhangbohan.feignconsumer.service.HelloService;

/**
 * file encoding: utf-8
 * Function :
 * Create : 2018/10/15 14:39
 *
 * @author : zhangbohan.dell@gmail.com
 * @version : 1.0
 */
@RestController
public class HelloController {
    private final
    HelloService helloService;


    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer () {
        return helloService.hello();
    }
}
