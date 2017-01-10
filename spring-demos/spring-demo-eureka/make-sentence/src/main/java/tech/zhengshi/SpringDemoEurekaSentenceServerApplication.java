package tech.zhengshi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringDemoEurekaSentenceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoEurekaSentenceServerApplication.class, args);
	}
}
