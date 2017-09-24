package com.zrain.springcloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Idan on 2017/9/24.
 */
@RestController
public class HomeController {

    @Value("${foo}")
    String foo;

    @RequestMapping(value = "/hi", method = {RequestMethod.GET})
    public String hi() {
        return foo;
    }

}
