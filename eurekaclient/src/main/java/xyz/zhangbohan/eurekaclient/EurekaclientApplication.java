package xyz.zhangbohan.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author bohan
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaclientApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaclientApplication.class, args);
    }
}
