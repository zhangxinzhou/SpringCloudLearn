package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

@Configuration
public class FeignLoggerLevelConfig {

	@Bean
	Logger.Level feignLoggerLevel(){//设置feign日志级别为full
		/*
		 * feign日志级别:
		 * none:不记录任何信息
		 * basic:仅记录请求方法,url以及响应状态吗和执行时间
		 * headers:除了basic级别记录的信息外,还有记录请求和响应的头信息
		 * full:记录所有请求与响应的明细,包括投信息,请求体,元数据
		 * */
		return Logger.Level.FULL;
	}
}
