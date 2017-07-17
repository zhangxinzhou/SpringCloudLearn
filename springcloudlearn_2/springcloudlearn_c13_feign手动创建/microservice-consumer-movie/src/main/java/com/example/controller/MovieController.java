package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserFeignClient;

import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;

@Import(FeignClientsConfiguration.class)
@RestController
public class MovieController {

	private UserFeignClient userUserFeignClient;
	
	private UserFeignClient adminUserFeignClient;
	
	@Autowired
	public MovieController(Decoder decoder,Encoder encoder,Client client,Contract contract){
		this.userUserFeignClient=Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract)
				                      .requestInterceptor(new BasicAuthRequestInterceptor("user", "user"))
				                      .target(UserFeignClient.class,"http://microservice-provider-user/");
		this.adminUserFeignClient=Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract)
                                       .requestInterceptor(new BasicAuthRequestInterceptor("admin", "admin"))
                                       .target(UserFeignClient.class,"http://microservice-provider-user/");
	}
	
	
	@GetMapping("/user-user/{id}")
	public User findUserByIdUser(@PathVariable Long id){
		return userUserFeignClient.findById(id);
	}
	
	@GetMapping("/user-admin/{id}")
	public User findUserByIdAdmin(@PathVariable Long id){
		return adminUserFeignClient.findById(id);
	}
	

}
