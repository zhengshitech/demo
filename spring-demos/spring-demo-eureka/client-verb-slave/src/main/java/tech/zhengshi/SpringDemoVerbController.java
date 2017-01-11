package tech.zhengshi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhengqiang on 2017/1/10 12:43.
 * desc:
 */
@RestController
public class SpringDemoVerbController {
    @Value("${actioins}") String actioins;

    @RequestMapping("/")
    public  String getWord() {
        String[] wordArray = actioins.split(",");
        int i = (int)Math.round(Math.random() * (wordArray.length - 1));
        return wordArray[i];
    }
}
