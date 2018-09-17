package tech.zhengshi.webapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tech.zhengshi.webapi.dto.Hello;
import tech.zhengshi.webapi.hystrix.HelloClientFallback;
import tech.zhengshi.webapi.hystrix.HelloClientFallbackFactory;

//@FeignClient(value = "web-service-subject-app", fallback = HelloClientFallback.class)
@FeignClient(name = "web-service-subject-app", fallbackFactory = HelloClientFallbackFactory.class)
public interface HelloClient {

    /**
     * xxx
     * @return xxx
     */
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    Hello iFailSometimes();


}
