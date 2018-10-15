package xyz.zhangbohan.ribbonconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author bohan
 */
@SpringBootApplication
@EnableDiscoveryClient   //开启服务发现功能
@EnableCircuitBreaker  //开启断路器功能
//@SpringCloudApplication //该注释包含了以上三个注释（一个SpringCloud标准应用包含服务发现以及断路器）
public class RibbonconsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RibbonconsumerApplication.class, args);
    }
}
