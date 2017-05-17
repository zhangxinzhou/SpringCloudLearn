package com.example.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;

@EnableDiscoveryClient
@EnableConfigServer
@Configuration
public class ConfigServerConfig {

}
