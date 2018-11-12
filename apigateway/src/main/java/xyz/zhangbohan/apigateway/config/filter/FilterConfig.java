/*
 * Copyright (c) 2018. zhangbohan.dell@gmail.com ,All Rights Reserved
 *
 */

package xyz.zhangbohan.apigateway.config.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * file encoding: utf-8
 * Function :
 * Create : 2018/10/17 14:18
 *
 * @author : zhangbohan.dell@gmail.com
 * @version : 1.0
 */
@Configuration
public class FilterConfig {
    @Bean
    public RoleFilter roleFilter() {
        return new RoleFilter();
    }
}
