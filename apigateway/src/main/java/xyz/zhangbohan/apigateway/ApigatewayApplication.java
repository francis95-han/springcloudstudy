package xyz.zhangbohan.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author bohan
 */
@SpringCloudApplication
@EnableZuulProxy
public class ApigatewayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ApigatewayApplication.class).web(true).run(args);
    }
}
