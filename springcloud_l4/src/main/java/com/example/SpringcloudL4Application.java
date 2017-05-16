package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Feign是一种声明式、模板化的HTTP客户端
 * Feign以接口和注解配置的方式，轻松实现了对compute-service服务的绑定，这样我们就可以在本地应用中像本地服务一下的调用它，并且做到了客户端均衡负载。
 * @author Administrator
 *
 */
@EnableFeignClients //开启Feign功能
@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudL4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudL4Application.class, args);
	}
}
