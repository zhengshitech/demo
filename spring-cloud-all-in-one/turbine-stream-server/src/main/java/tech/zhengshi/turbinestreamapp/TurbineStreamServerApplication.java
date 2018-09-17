package tech.zhengshi.turbinestreamapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * @author H
 */
@SpringBootApplication
@EnableTurbineStream
@EnableEurekaClient
@EnableHystrixDashboard
public class TurbineStreamServerApplication {

    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(TurbineStreamServerApplication.class, args);
    }

//    @Bean
//    public MessageConverter messageConverter() {
//        return new MappingJackson2MessageConverter();
//    }
}
