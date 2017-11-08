package com.example.tdd2;

import com.z.MyException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhengqiang on 2017/11/7 20:13.
 * desc:
 */
@RestController
public class HelloController {

    @RequestMapping("/zz/hello")
    public String index() {
        return "Greetings from Spring Boot!2";
    }


    @PostMapping("/zz/post/{test_id}")
    public String post(@PathVariable("test_id") String testId) throws Exception {

        System.out.println("#####" + testId);
        if (testId.contains("cat"))
            throw new Exception("test exception");
        return testId;
    }


    @RequestMapping("/zz/exception/test/{msg}")
    public String exceptionTest(@PathVariable("msg") String testMsg) throws Exception {

        System.out.println("#####" + testMsg);
        if (testMsg.contains("exception"))
            throw new MyException(testMsg);
        return testMsg;
    }


}