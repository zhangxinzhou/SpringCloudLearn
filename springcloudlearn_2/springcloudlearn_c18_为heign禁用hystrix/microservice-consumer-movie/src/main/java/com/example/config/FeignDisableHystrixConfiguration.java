package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import feign.Feign;
/**
 * 禁用hystrix的配置类
 * @author Administrator
 *
 */
@Configuration
public class FeignDisableHystrixConfiguration {

	@Bean
	@Scope("prototype")
	public Feign.Builder feignBuilder(){
		return Feign.builder();
	}
}
