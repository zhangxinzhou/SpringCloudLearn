package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.ComputeService;

@RestController
public class ConsumerController {

	@Autowired
	ComputeService  computeService;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(){
		return computeService.addService();
	}
}
