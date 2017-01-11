package tech.zhengshi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableEurekaServer
@EnableFeignClients
@Configuration
@EnableAutoConfiguration
public class SpringDemoEurekaSentenceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoEurekaSentenceServerApplication.class, args);
	}
}
