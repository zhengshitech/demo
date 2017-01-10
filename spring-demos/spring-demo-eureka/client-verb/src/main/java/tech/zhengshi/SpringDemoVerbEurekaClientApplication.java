package tech.zhengshi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringDemoVerbEurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoVerbEurekaClientApplication.class, args);
    }
}
