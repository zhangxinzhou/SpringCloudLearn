package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class MicroserviceHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceHystrixDashboardApplication.class, args);
	}
}
