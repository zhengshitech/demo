package tech.zhengshi.webapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author H
 * @date 2017/1/11
 */
@FeignClient(name = "web-service-subject-app")
public interface SubjectService {
    /**
     * get subject
     * @return subject string
     */
    @RequestMapping(value = "/subject", method = RequestMethod.GET)
    String getSubject();
}
