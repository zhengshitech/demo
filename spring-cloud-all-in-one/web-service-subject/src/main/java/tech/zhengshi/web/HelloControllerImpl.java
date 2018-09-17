package tech.zhengshi.web;

import org.springframework.web.bind.annotation.RestController;
import tech.zhengshi.webapi.HelloClient;
import tech.zhengshi.webapi.dto.Hello;

import java.util.Random;

/**
 * @author H
 */
@RestController
public class HelloControllerImpl implements HelloClient {
    @Override
    public Hello iFailSometimes() {

//        Random random = new Random();
//        int r = random.nextInt();
//        if (r % 2 == 0) {
//            throw new RuntimeException("fall back test message!!!");
//        }

        return new Hello("您好 正常的业务！！！");
    }
}
