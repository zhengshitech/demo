package tech.zhengshi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author H
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"tech.zhengshi.webapi"})
@EnableCircuitBreaker
public class WebServiceSentenceTurbineClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServiceSentenceTurbineClientApplication.class, args);
    }

}
