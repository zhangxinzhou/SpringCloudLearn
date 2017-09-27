package com.example.config;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages={"com.example.service"})
@Configuration
public class FeignClientConfig {

}
