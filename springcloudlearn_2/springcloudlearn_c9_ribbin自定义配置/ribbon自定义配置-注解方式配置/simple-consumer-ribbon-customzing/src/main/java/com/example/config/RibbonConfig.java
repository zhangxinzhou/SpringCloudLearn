package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * 该类为Ribbon的配置类
 * @author Administrator
 *
 */
@Configuration
public class RibbonConfig {

	
	@Bean
	public IRule ribbonRule(){
		//负载均衡配置,改为随机
		return new RandomRule();
	}
}
