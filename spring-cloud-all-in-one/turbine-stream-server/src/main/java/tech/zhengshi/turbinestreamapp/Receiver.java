package tech.zhengshi.turbinestreamapp;

import org.springframework.cloud.netflix.turbine.stream.TurbineStreamClient;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.io.StringReader;

@Component
public class Receiver {


    @StreamListener(TurbineStreamClient.INPUT)
    public void handle(Message data) {

//        Object payload = data.getPayload();
//        byte[] xx = (byte[]) payload;
//        String msg = new String(xx);
//        System.out.println("接收信息,姓名: " + msg);
    }


}