package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Ribbon负载均衡
 * 增加断路器
 * @author Administrator
 *
 */
@EnableCircuitBreaker //@EnableCircuitBreaker注解开启断路器功能
@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudL3Application {
	
	@Bean
	@LoadBalanced //@LoadBalanced注解开启均衡负载能力
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudL3Application.class, args);
	}
	

}
