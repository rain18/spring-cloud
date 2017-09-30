package com.zrain.springcloud.servicemiya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Idan on 2017/9/27.
 */
@RestController
public class HiController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String home(){
        return "hi i'm miya!";
    }

    @RequestMapping("/miya")
    public String info(){
        return restTemplate.getForObject("http://localhost:8988/info",String.class);
    }



}
