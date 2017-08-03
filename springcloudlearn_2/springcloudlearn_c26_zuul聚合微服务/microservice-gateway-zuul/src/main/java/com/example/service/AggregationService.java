package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import rx.Observable;



@Service
public class AggregationService {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="fallback")
	public Observable<User> getUserById(Long id){	
		//创建一个被观察者
		return Observable.create(observer->{
			//请求用户微服务的/{id}端点
			User user=restTemplate.getForObject("http://microservice-provider-user/{id}", User.class,id);
			observer.onNext(user);
			observer.onCompleted();
		});
	}
	
	@HystrixCommand(fallbackMethod="fallback")
	public Observable<User> getMovieUserByUserId(Long id){
		//请求电影为服务的/user/{id}端点
		return Observable.create(observer->{
			User movieUser=restTemplate.getForObject("http://microservice-consumer-movie/user/{id}", User.class,id);
			observer.onNext(movieUser);
			observer.onCompleted();
		});
	}
	
	public User fallback(Long id){
		User user=new User();
		user.setId(-1L);
		user.setName("默认失败用户");
		return user;
	}
}
