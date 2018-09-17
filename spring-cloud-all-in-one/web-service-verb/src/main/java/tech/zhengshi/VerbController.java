package tech.zhengshi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;
import tech.zhengshi.webapi.VerbService;

/**
 * Created by zhengqiang on 2017/1/10 12:43.
 * desc:
 */
@RestController
@RefreshScope
public class VerbController implements VerbService {
    @Value("${actioins}")
    String actioins;

    @Override
    public String getVerb() {
        String[] wordArray = actioins.split(",");
        int i = (int) Math.round(Math.random() * (wordArray.length - 1));
        return wordArray[i];
    }
}
