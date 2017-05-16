package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.ComputeClient;

/**
 * 消费者controller
 * @author Administrator
 *
 */
@RestController
public class ConsumerController {

	@Autowired
	ComputeClient computeClient;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Integer add(){
		return computeClient.add(10, 20);
	}
}
