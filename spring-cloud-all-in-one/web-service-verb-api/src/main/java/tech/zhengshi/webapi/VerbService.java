package tech.zhengshi.webapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by H on 2017/1/11.
 */
@FeignClient(name = "web-service-verb-app")
public interface VerbService {
    @RequestMapping(value = "/verb", method = RequestMethod.GET)
    public String getVerb();
}
