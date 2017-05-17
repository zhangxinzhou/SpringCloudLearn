package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.User;

@RestController
public class ConsumerController {

	@Value("${user.userServiceUrl}")
	String userServiceUrl;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/user/{id}")
	public User findUserById(@PathVariable Long id){
		return restTemplate.getForObject(userServiceUrl+id, User.class);
	}
}
