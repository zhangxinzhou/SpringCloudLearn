package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
/**
 * zuul服务网关
 * @author Administrator
 *
 */
@SpringCloudApplication//整合了@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker
public class SpringcloudL7Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudL7Application.class, args);
	}
}
