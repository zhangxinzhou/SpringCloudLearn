package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigClientController {

	@Value("${profile}")
	private String profile;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/profile")
	public String hello(){
		return this.profile;
	}
	
	@GetMapping("/env")
	public String env(){	
		StringBuffer sb=new StringBuffer();
		String[] arr=env.getActiveProfiles();
		for (String string : arr) {
			sb.append(string);
			sb.append("\n");
		}
		return sb.toString();
	}
}

