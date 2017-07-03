package com.example.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.User;
import com.example.service.fallback.HelloServiceFallback;

@FeignClient(name="hello-service",fallback=HelloServiceFallback.class,decode404=true) //name为服务提供方的spring.application.name(不区分大小写)
//FIXME 注意,这里的fallback方法测试失败,没有起到服务降级的作用,此坑以后找机会填
public interface HelloService {
	

	@RequestMapping("/hello")
	String hello();
	
	/*注意在feign中绑定参数必须通过value为@RequestParam,@RequestHeader指明具体的参数名,否则会抛出IlleagelStateException异常*/
	@RequestMapping(value="/hello1",method=RequestMethod.GET)
	String hello(@RequestParam(value="name") String name);
	
	@RequestMapping(value="/hello2",method=RequestMethod.GET)
	User hello(@RequestHeader(value="name") String name,@RequestHeader(value="age") Integer age);
	
	@RequestMapping(value="/hello3",method=RequestMethod.POST)
	String hello(@RequestBody User user);
}
