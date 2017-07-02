package com.example.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.User;

@FeignClient("hello-service") //hello-service是服务名,不区分大小写.
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
