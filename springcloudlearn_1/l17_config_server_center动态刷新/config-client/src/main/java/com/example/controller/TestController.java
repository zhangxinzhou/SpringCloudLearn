package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

	@Value("${from}")
	private String from;
	
	@Autowired
	private Environment env;
	
	@RequestMapping("/from")
	public String from(){
		return this.from;
	}
	
	@RequestMapping("/from/{str}")
	public String from(@PathVariable String str){		
		return env.getProperty("str","underfined");
	}
		
	@RequestMapping("/test")
	public String test(){
		return "test";
	}
}
