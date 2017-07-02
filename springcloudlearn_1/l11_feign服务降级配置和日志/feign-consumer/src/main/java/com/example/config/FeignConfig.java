package com.example.config;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages={"com.example.service"})   //开启feign功能,basePackages为必填参数,否则被@FeignClient注解的类spring无法初始化(至少当前版本是这样)
@Configuration
public class FeignConfig {

}
