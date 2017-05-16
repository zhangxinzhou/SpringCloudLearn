package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka服务注册中心
 * @author Administrator
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class SpringcloudL1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudL1Application.class, args);
	}
}
