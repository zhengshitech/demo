package tech.zhengshi.biz;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.zhengshi.webapi.SubjectService;
import tech.zhengshi.webapi.VerbService;

/**
 * Created by zhengqiang on 2017/1/23 15:11.
 * desc:
 */
@Service("sentenceManager")
public class SentenceManagerImpl implements SentenceManager {

    @Autowired
    SubjectService subjectService;

    @Autowired
    VerbService verbService;


    @Override
    public String getSentence() {
        return getSubject() + " " + getVerb();
    }

    @Override
    @HystrixCommand(fallbackMethod = "getFallbackSubject")
    public String getSubject() {
        return subjectService.getSubject();
    }

    @Override
    @HystrixCommand(fallbackMethod = "getFallbackVerb")
    public String getVerb() {
        return verbService.getVerb();
    }


    public String getFallbackSubject() {
        return "某人";
    }

    public String getFallbackVerb() {
        return "某事";
    }
}
