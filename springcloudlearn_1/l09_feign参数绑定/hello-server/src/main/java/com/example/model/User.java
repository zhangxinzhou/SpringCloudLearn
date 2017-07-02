package com.example.model;

public class User {

	private String name;
	private Integer age;
	//默认构造函数必须存在,否则spring cloud feign会抛出异常(类似spring初始话bean一样)
	public User() {
		super();
	}
	public User(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	
}
