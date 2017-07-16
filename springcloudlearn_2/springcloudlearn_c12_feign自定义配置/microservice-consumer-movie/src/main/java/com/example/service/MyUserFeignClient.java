package com.example.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.config.FeignConfiguration;
import com.example.model.User;

import feign.RequestLine;

@FeignClient(name="microservice-provider-user",configuration=FeignConfiguration.class)
public interface MyUserFeignClient {

	@RequestLine("GET /{id}")
	public User findById(@PathVariable("id") Long id);
}
