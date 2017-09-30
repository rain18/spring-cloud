package com.zrain.springcloud.zipkinhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Idan on 2017/9/29.
 */
@RestController
public class HiController {

    @Autowired
    private RestTemplate restTemplate;

}
