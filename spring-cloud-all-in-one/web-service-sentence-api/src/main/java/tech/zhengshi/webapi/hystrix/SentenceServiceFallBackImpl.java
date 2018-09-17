package tech.zhengshi.webapi.hystrix;

import org.springframework.stereotype.Component;
import tech.zhengshi.webapi.SentenceService;

/**
 * @author H
 */
@Component
public class SentenceServiceFallBackImpl implements SentenceService {
    @Override
    public String getSentence() {
        return "The Server Is Sleeping Now !!!";
    }
}
