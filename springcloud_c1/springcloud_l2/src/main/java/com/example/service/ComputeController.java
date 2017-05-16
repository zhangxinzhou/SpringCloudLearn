package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComputeController {

	private final Logger log=LoggerFactory.getLogger(getClass());
	
	@Autowired
	DiscoveryClient client;
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public Integer add(@RequestParam Integer a,@RequestParam Integer b){	
		ServiceInstance instance=client.getLocalServiceInstance();
		Integer r=a+b;
		log.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
		return r;
	}
}
