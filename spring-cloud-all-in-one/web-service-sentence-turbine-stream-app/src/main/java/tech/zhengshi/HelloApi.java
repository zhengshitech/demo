package tech.zhengshi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tech.zhengshi.webapi.HelloClient;

/**
 * @author H
 */
@RestController
public class HelloApi {

    @Autowired
    private HelloClient helloClient;

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    String sayHello() {
        return helloClient.iFailSometimes().getWord();
    }

}
