package tech.zhengshi.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;
import tech.zhengshi.webapi.SubjectService;

/**
 * Created by zhengqiang on 2017/1/10 12:43.
 * desc:
 */
@RestController
@RefreshScope
public class SubjectController implements SubjectService {
    @Value("${words}")
    String words;

    @Override
    public String getSubject() {
        String[] wordArray = words.split(",");
        int i = (int) Math.round(Math.random() * (wordArray.length - 1));
        return wordArray[i];
    }
}
