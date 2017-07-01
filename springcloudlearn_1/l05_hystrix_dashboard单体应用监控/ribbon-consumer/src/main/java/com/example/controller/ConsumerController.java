package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.HelloService;


@RestController
public class ConsumerController {

	@Autowired
	HelloService helloService;
	
	@RequestMapping(value="/ribbon-consumer",method=RequestMethod.GET)
	public String helloConsumer(){
		return helloService.helloService();
	}

}
