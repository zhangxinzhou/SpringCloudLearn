package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;
import feign.auth.BasicAuthRequestInterceptor;

/**
 * feign配置类
 * @author Administrator
 *
 */
@Configuration
public class FeignConfiguration {

	@Bean
	public Contract feignContract(){
		return new feign.Contract.Default();
	}
	
	//认证拦截器
	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
		return new BasicAuthRequestInterceptor("admin", "admin");
	}
} 
