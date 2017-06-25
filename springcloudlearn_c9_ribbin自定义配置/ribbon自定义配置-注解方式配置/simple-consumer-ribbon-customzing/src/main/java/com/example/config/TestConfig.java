package com.example.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * 使用RibbonClient,为特定name的Ribbon client自定义配置
 * 使用@RibbonClient的configuration属性,指定Ribbon的配置类
 * @author Administrator
 *
 */
@RibbonClient(name="eureka-client-provider",configuration=RibbonConfig.class)
@Configuration
public class TestConfig {

}
