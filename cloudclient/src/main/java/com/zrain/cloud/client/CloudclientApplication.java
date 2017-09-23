package com.zrain.cloud.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CloudclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudclientApplication.class, args);
	}
}
