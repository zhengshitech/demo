package tech.zhengshi.webapi.hystrix;

import org.springframework.stereotype.Component;
import tech.zhengshi.webapi.HelloClient;
import tech.zhengshi.webapi.dto.Hello;
@Component
public class HelloClientFallback implements HelloClient {
    @Override
    public Hello iFailSometimes() {
        return new Hello("fallback in the client");
    }
}
