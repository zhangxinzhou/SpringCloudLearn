package com.example.service;

import org.springframework.stereotype.Component;

/**
 * 远程消费方法失败时,使用此方法
 * @author Administrator
 *
 */
@Component
public class ComputeClientHystrix implements ComputeClient {

	@Override
	public Integer add(Integer a, Integer b) {
		return -9999;
	}

}
