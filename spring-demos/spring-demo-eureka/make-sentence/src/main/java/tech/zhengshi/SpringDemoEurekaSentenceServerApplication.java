package tech.zhengshi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import javax.servlet.Filter;

@SpringBootApplication
@EnableEurekaServer
@EnableFeignClients
@Configuration
@EnableAutoConfiguration
@EnableHystrix
@EnableHystrixDashboard
@EnableZuulProxy
public class SpringDemoEurekaSentenceServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoEurekaSentenceServerApplication.class, args);
    }

    @Bean
    public Filter shallowEtagHeaderFilter() {
        System.err.println("do it");
        return new ShallowEtagHeaderFilter();
    }
}
