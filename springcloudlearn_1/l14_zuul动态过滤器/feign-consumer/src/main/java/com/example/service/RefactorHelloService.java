package com.example.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.example.api.ApiHelloService;

@FeignClient("hello-service") //hello-service是服务名,不区分大小写
public interface RefactorHelloService extends ApiHelloService{

	
}
