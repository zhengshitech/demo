package tech.zhengshi;

import org.apache.commons.lang.time.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ExceptionTestDemo {
    AtomicInteger atomicInteger = new AtomicInteger(0);

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Msg test() {
        int code = -1;
        try {
            code = demo1();
        } catch (Exception e) {
            e.printStackTrace();
            return new Msg(code, e.getMessage());
        }
        return new Msg(code, "success");
    }

    public int demo1() {
        int i = atomicInteger.incrementAndGet();
        if (i % 10 == 0) {
            throw new RuntimeException("这里是抛出的一个异常");
        }
        return 200;
    }

    public int demo2() {
        int i = atomicInteger.incrementAndGet();
        if (i % 10 == 0) {
            throw new RuntimeException("这里是抛出的一个异常");
        }
        return 200;
    }

    static Map<Integer, Msg> exceptionDictory = init();


    public static void main(String[] args) throws CloneNotSupportedException {
        AtomicLong timer = new AtomicLong();
        StopWatch stopWatch = new StopWatch();



        int TIMES = 2000;
        for (int i = 0; i < TIMES; i++) {
            stopWatch.reset();
            stopWatch.start();
//            gen1();
            gen2();

            stopWatch.stop();
            timer.addAndGet(stopWatch.getTime());
            System.out.println(timer.get());
        }
        System.out.println();
        long average = timer.get() / TIMES;


        System.out.println("--------------------" + average + "ms");
    }

    private static void gen2() {
        for (int i = 0; i < 100000; i++) {
            Msg clone = exceptionDictory.get(i);
//            clone.setCode(i);
//            clone.setMsg("msg+" + i);
        }
    }

    private static Map<Integer, Msg> init() {
        Map<Integer, Msg> map = new HashMap<>(100000);
        for (int i = 0; i < 100000; i++) {
            map.put(i, new Msg(i, "msg+" + i));
        }
        System.out.println("$$$$$$$$init over$$$$$$$$");
        return map;
    }


    static Msg baseMsg = new Msg(200, "");

    private static void gen() {
        for (int i = 0; i < 100000; i++) {
            new Msg(i, "msg+" + i);
        }
    }

    private static void gen1() throws CloneNotSupportedException {
        for (int i = 0; i < 100000; i++) {
            Msg clone = (Msg) baseMsg.clone();
//            clone.setCode(i);
//            clone.setMsg("msg+" + i);
        }
    }


}
