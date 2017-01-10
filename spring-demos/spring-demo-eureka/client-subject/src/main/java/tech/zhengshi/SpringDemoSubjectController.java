package tech.zhengshi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhengqiang on 2017/1/10 12:43.
 * desc:
 */
@Configuration
@EnableAutoConfiguration
@RestController
public class SpringDemoSubjectController {
    @Value("${words}") String words;

    @RequestMapping("/ssss")
    public  String getWord() {
        String[] wordArray = words.split(",");
        int i = (int)Math.round(Math.random() * (wordArray.length - 1));
        return wordArray[i];
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringDemoSubjectController.class, args);
    }

}
