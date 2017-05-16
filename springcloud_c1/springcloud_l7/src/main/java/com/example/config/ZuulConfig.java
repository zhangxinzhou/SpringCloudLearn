package com.example.config;

import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.filter.AccessFilter;

@EnableZuulProxy //@EnableZuulProxy注解开启Zuul
@Configuration
public class ZuulConfig {

	@Bean
	public AccessFilter accessFilter(){
		return new AccessFilter();
	}
}
