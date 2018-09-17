package tech.zhengshi;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tech.zhengshi.biz.SentenceManager;
import tech.zhengshi.webapi.SentenceService;
import tech.zhengshi.webapi.SubjectService;
import tech.zhengshi.webapi.VerbService;

/**
 * @author zhengqiang
 * @date 2017/1/10 15:47
 * desc:
 */
@RestController
public class SentenceController implements SentenceService {

    @Autowired
    private SentenceManager sentenceManager;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private VerbService verbService;

    public static final String getFallbackSentence() {
        return "fall back message in method......!";
    }

    /**
     * public static final String getFallbackSentence(){
     * return "Server is Sleeping!";
     * }
     * <p>
     * //一定要@HystrixCommand(fallbackMethod="getFallbackSentence") 不然不出hystrix监控页面图形！！！！！！！！！！
     *
     * @HystrixCommand(fallbackMethod="getFallbackSentence")
     * @RequestMapping(value = "/getSentence", method = RequestMethod.GET)
     */
    @HystrixCommand(fallbackMethod = "getFallbackSentence")
    @Override
    public String getSentence() {

        a();
        String sentence = subjectService.getSubject() + ", " + verbService.getVerb() + "!";
        return sentence;
    }

    public void a() {
        a1();
    }

    public void a1() {
    }


}