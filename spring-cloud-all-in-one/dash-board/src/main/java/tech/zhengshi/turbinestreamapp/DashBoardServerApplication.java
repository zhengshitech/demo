package tech.zhengshi.turbinestreamapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author H
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrixDashboard
public class DashBoardServerApplication {


    public static void main(String[] args) {
        SpringApplication.run(DashBoardServerApplication.class, args);
    }

}
