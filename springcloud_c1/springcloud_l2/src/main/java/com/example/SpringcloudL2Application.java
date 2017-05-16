package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 服务提供者
 * @author Administrator
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudL2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudL2Application.class, args);
	}
}
