package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {
	
	private final Logger logger=LoggerFactory.getLogger(getClass()); 

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="helloFallback",commandKey="helloKey")
	public String helloService(){
		long start=System.currentTimeMillis();
		String result= restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
		long end=System.currentTimeMillis();
		logger.info("Spend time : [{}] ms",(end-start));
		return result;
	}
	
	public String helloFallback(){
		return "error";
	}
}
