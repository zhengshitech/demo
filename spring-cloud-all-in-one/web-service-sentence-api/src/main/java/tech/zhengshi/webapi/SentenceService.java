package tech.zhengshi.webapi;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tech.zhengshi.webapi.hystrix.SentenceServiceFallBackImpl;

/**
 * @author H
 * @date 2017/1/11
 */
@FeignClient(name = "web-service-sentence-app", fallback = SentenceServiceFallBackImpl.class)
public interface SentenceService {
    /**
     * make a sentence
     *
     * @return sentence
     */
    @RequestMapping(value = "/getSentence", method = RequestMethod.GET)
    String getSentence();
}
