/*
 * Copyright (c) 2018. zhangbohan.dell@gmail.com ,All Rights Reserved
 *
 */

package xyz.zhangbohan.eurekaclient.controller;


import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * file encoding: utf-8
 * Function :
 * Create : 2018/10/11 19:47
 *
 * @author : zhangbohan.dell@gmail.com
 * @version : 1.0
 */
@RestController
@Log4j
public class HelloController {

    @Resource
    private DiscoveryClient client;

    @Resource
    private Registration registration;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        //getLocalServiceInstance 方法已经过时，可以采用下边的testBalance
        ServiceInstance instance = client.getLocalServiceInstance();
        log.info(
                "/test, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() );
        return "From Service-A";

    }

    @RequestMapping(value = "/testBalance", method = RequestMethod.GET)
    public String testBalance(@RequestParam String param) {
        ServiceInstance instance = serviceInstance();
        String result = "/testBalance, host:port=" + instance.getUri()  + ", "
                + "service_id:" + instance.getServiceId();
        log.info(result);
        return "From Service-A , " + result;
    }

    public ServiceInstance serviceInstance() {
        List<ServiceInstance> list = client.getInstances(registration.getServiceId());
        if (list != null && list.size() > 0) {
            for(ServiceInstance itm : list){
                if (itm.getPort() == 2001) {
                    return itm;
                }
            }
        }
        return null;
    }
}
