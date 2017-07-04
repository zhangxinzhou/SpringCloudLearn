package com.example.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.User;

/**
 * 为了避免重名造成的困扰,该名为ApiHelloService
 * @author Administrator
 *
 */
@RequestMapping("/refactor")
public interface ApiHelloService {

	
	@RequestMapping(value="/hello4",method=RequestMethod.GET)
	String hello(@RequestParam(value="name") String name);
	
	@RequestMapping(value="/hello5",method=RequestMethod.GET)
	User hello(@RequestHeader(value="name") String name,@RequestHeader(value="age") Integer age);
	
	@RequestMapping(value="/hello6",method=RequestMethod.POST)
	String hello(@RequestBody User user);
}
