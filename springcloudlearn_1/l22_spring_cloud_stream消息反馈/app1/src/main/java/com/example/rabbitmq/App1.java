package com.example.rabbitmq;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;

@EnableBinding(value={Processor.class})
public class App1 {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	public Object reveiveFromInput(Object payload){
		logger.info("Received : [{}]"+payload);
		return "From input channel Return - "+payload;
	}
}
