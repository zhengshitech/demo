package tech.zhengshi;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by zhengqiang on 2017/1/10 15:47.
 * desc:
 */
@RestController
public class MakeSentence {

    //    @Autowired
//    DiscoveryClient client;
    @Autowired
    LoadBalancerClient client;

//    @Autowired
//    SubjectClient subjectClient;

    public static final String getFallbackSubject(){
        return "make sentence error!";
    }



    @HystrixCommand(fallbackMethod="getFallbackSubject")
    @RequestMapping("/getSentence")
    public String getSentence() throws URISyntaxException {

//        return "rigth sentense...";



        String subject = getSubject("web-service-subject-app");//subjectClient.getWord();
        String action = getVerb("web-service-verb-app");
        String sentence = subject + " " + action + ".";
        System.out.println(sentence);
        return sentence;//大小写不区分


    }



    public String getVerb(String service) throws URISyntaxException {
        ServiceInstance serviceInstance = client.choose(service);
        String url = serviceInstance.getUri() + "/verb";
        URI uri = new URI(url);
        if (uri != null) {
            String forObject = (new RestTemplate()).getForObject(uri, String.class);
            return forObject;
        }
        return "##### ERR MSG ####";
    }

    public String getSubject(String service) throws URISyntaxException {
        ServiceInstance serviceInstance = client.choose(service);
        String url = serviceInstance.getUri() + "/subject";
        URI uri = new URI(url);
        if (uri != null) {
            String forObject = (new RestTemplate()).getForObject(uri, String.class);
            return forObject;
        }
        return "##### ERR MSG ####";
    }

    public String getWord(String service) {
            ServiceInstance serviceInstance = client.choose(service);
            URI uri = serviceInstance.getUri();
            if (uri != null) {
                String forObject = (new RestTemplate()).getForObject(uri, String.class);
                return forObject;
            }
            return "##### ERR MSG ####";
    }
}