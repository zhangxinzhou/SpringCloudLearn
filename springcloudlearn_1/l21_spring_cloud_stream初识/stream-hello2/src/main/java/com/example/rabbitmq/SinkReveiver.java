package com.example.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;

//spring integration原生的@ServiceActivator和@InboundChannelAdapter来实现
@EnableBinding(Sink.class)
public class SinkReveiver {

	private final Logger logger=LoggerFactory.getLogger(getClass());
	
	@ServiceActivator(inputChannel=Sink.INPUT)
	public void reveive(Object payload){
		logger.info("Received : [{}]",payload);
	}
}
