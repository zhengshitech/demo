package tech.zhengshi.webapi.hystrix;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import tech.zhengshi.webapi.HelloClient;
import tech.zhengshi.webapi.dto.Hello;

@Component
public class HelloClientFallbackFactory implements FallbackFactory<HelloClient> {
    @Override
    public HelloClient create(Throwable cause) {
        return new HelloClient() {
            @Override
            public Hello iFailSometimes() {
                return new Hello("HelloClientFallback; Reason was: " + cause.getMessage());
            }
        };
    }
}
