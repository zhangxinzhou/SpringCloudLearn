package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
/**
 * feign配置类
 * @author Administrator
 *
 */
@Configuration
public class FeignConfiguration {
	
	@Bean
	Logger.Level feignLoggerLevel(){
		return Logger.Level.FULL;
	}
} 
