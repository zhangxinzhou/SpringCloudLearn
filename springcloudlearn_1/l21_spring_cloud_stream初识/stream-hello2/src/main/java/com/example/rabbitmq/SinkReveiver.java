package com.example.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.example.iface.SinkSender;

@EnableBinding(value={Sink.class,SinkSender.class})
public class SinkReveiver {

	private final Logger logger=LoggerFactory.getLogger(getClass());
	
	@StreamListener(Sink.INPUT)
	public void reveive(Object payload){
		logger.info("Received : [{}]",payload);
	}
}
