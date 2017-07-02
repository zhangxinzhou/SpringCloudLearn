package com.example.service.fallback;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.User;
import com.example.service.HelloService;

@Service  //注意需要注册为spring bean
public class HelloServiceFallback implements HelloService{

	@Override
	public String hello() {
		return "error";
	}

	@Override
	public String hello(@RequestParam(value="name") String name) {
		return "error";
	}

	@Override
	public User hello(@RequestHeader(value="name") String name,@RequestHeader(value="age")  Integer age) {
		return new User("未知", 0);
	}

	@Override
	public String hello(@RequestBody User user) {
		return "error";
	}

}
