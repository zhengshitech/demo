package tech.zhengshi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhengqiang on 2017/1/10 12:43.
 * desc:
 */
@RestController
public class SpringDemoSubjectController {
    @Value("${words}") String words;

    @RequestMapping("/subject")
    public  String getWord() {
        String[] wordArray = words.split(",");
        int i = (int)Math.round(Math.random() * (wordArray.length - 1));
        return wordArray[i];
    }
}
