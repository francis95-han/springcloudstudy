/*
 * Copyright (c) 2018. zhangbohan.dell@gmail.com ,All Rights Reserved
 *
 */

package xyz.zhangbohan.feignconsumer.config;


import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * file encoding: utf-8
 * Function :
 * Create : 2018/10/15 17:25
 *
 * @author : zhangbohan.dell@gmail.com
 * @version : 1.0
 */
@Configuration
public class DisableHystrixConfig {
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
