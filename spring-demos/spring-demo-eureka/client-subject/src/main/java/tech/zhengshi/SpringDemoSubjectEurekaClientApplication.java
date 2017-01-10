package tech.zhengshi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringDemoSubjectEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoSubjectEurekaClientApplication.class, args);
	}
}
