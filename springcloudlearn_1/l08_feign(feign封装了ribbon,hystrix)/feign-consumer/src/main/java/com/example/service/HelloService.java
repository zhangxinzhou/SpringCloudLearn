package com.example.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("hello-service") //hello-service是服务名,不区分大小写.
public interface HelloService {

	@RequestMapping("/hello")
	String hello();
}
