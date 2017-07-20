package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.config.FeignDisableHystrixConfiguration;
import com.example.model.User;

import feign.hystrix.FallbackFactory;

@FeignClient(name = "microservice-provider-user", 
             fallbackFactory=FeignClientFallbackFactory.class,
             configuration=FeignDisableHystrixConfiguration.class)//禁用hystrix,服务无法降级,无法调用fallback函数,禁用成功
public interface UserFeignClient {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
}

/**
 * /** 回退类FeignClientFallback需实现Feign Client接口 FeignClientFallback也可以是public
 * class，没有区别
 */

@Component
class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

	private static final Logger logger=LoggerFactory.getLogger(FeignClientFallbackFactory.class);
	
	@Override
	public UserFeignClient create(Throwable cause) {
		return new UserFeignClient() {			
			@Override
			public User findById(Long id) {
				//日志最好放在各个fallback方法中,而不要直接放在create方法中,否则在引用启动时就会打印该日志
				FeignClientFallbackFactory.logger.info("fallback;reason was :",cause);
				User user=new User();
				user.setId(-1L);
				user.setUsername("默认用户");
				return user;
			}
		};
	}
}
