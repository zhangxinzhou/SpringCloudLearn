package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserFeignClient;

@RestController
public class ConsumerController {
	
	
	@Autowired
	UserFeignClient userFeignClient;
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public User findUserById(@PathVariable Long id){
		return userFeignClient.findById(id);
	}
	

}
