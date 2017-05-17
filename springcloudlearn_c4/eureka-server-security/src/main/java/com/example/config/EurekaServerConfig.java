package com.example.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;

/**
 * 想其他服务注册自己,同时为其他服务提供注册服务
 * @author Administrator
 *
 */
@EnableDiscoveryClient
@EnableEurekaServer
@Configuration
public class EurekaServerConfig {

}
