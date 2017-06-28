package com.example.feigninterface;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.User;

@FeignClient(name="microservice-provider-user")
public interface MyUserFeignClient {

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
}
