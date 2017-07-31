package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@EnableSidecar
@SpringBootApplication
public class MicroserviceSidecarApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSidecarApplication.class, args);
	}
}
