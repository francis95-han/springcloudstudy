/*
 * Copyright (c) 2018. zhangbohan.dell@gmail.com ,All Rights Reserved
 *
 */

package xyz.zhangbohan.ribbonconsumer.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * file encoding: utf-8
 * Function :
 * Create : 2018/10/13 11:08
 *
 * @author : zhangbohan.dell@gmail.com
 * @version : 1.0
 */
public interface HelloService {
    @HystrixCommand(fallbackMethod = "helloFallback")
    String helloService();
}
