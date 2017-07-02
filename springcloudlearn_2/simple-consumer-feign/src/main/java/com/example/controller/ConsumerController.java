package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.example.feigninterface.UserFeignClient;
import com.example.model.User;

@RestController
public class ConsumerController {
	
	
	@Autowired
	UserFeignClient userFeignClient;
	
	@GetMapping("/user/{id}")
	public User findUserById(@PathVariable Long id){
		return userFeignClient.findById(id);
	}
	

}
