package tech.zhengshi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


/**
 * @author H
 */
@Configuration
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = {"tech.zhengshi.webapi.hystrix","tech.zhengshi.web"})
@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients(basePackages = {"tech.zhengshi.webapi"})
@EnableHystrix
public class WebServiceSubjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServiceSubjectApplication.class, args);
    }
}
