package com.example.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Configuration;

@EnableDiscoveryClient
@EnableTurbine           //开启turbine
@Configuration
public class TurbineConfig {

}
