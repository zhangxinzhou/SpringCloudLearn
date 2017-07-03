package com.example.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.ApiHelloService;
import com.example.model.User;

@RestController
public class RefactorHelloController implements ApiHelloService{


	@Override
	public String hello(@RequestParam(value="name") String name) {
		return "Hello "+name;
	}

	@Override
	public User hello(@RequestHeader(value="name") String name, Integer age) {
		return new User(name, age);
	}

	@Override
	public String hello(@RequestBody User user) {
		return "Hello "+user.getName()+", "+user.getAge();
	}


}
