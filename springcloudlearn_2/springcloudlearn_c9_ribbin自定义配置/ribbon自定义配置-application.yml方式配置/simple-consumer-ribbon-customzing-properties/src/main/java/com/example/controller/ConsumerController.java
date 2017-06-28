package com.example.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.User;

@RestController
public class ConsumerController {
	
	private final Logger logger=LoggerFactory.getLogger(getClass());
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	LoadBalancerClient loadBalancerClient;
	
	@GetMapping("/user/{id}")
	public User findUserById(@PathVariable Long id){
		return restTemplate.getForObject("http://eureka-client-provider/"+id, User.class);
		//return this.restTemplate.getForObject("http://eureka-client-provider/"+id, User.class);
	}
	
	@GetMapping("/log-instance")
	public void logUserInstance(){
		ServiceInstance serviceInstance=this.loadBalancerClient.choose("eureka-client-provider");
		logger.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
	}
}
