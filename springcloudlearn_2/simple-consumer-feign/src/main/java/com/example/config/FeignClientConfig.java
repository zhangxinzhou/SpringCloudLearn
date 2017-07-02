package com.example.config;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages={"com.example.feigninterface"}) //坑,basePackages要设置@FeignClient的包路径否则启动失败
@Configuration
public class FeignClientConfig {

}
