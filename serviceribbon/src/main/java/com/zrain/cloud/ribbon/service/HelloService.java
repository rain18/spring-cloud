package com.zrain.cloud.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Idan on 2017/9/22.
 */
@Service
public class HelloService {

    private String serverUrl = "http://SERVICE-HI/hi/";

    @Autowired
    private RestTemplate restTemplate;
//
//    public String hiService(String name) {
//        return restTemplate.getForObject(serverUrl+"?name="+name, String.class);
//    }

    /**
     * 加入断路器 hystrix
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject(serverUrl+"?name="+name, String.class);
    }

    public String hiError(String name) {
        return "hi, "+ name+", sorry, error!";
    }

}
