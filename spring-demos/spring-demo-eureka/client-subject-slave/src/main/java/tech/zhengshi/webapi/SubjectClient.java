package tech.zhengshi.webapi;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by H on 2017/1/11.
 */
@FeignClient(name = "zhengshitech-eureka-client-subject")
public interface SubjectClient {
    @RequestMapping(value = "/subject", method = RequestMethod.GET)
    public String getWord();
}
