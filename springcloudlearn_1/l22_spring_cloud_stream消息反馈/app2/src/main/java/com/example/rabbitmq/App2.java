package com.example.rabbitmq;

import java.util.Date;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

@EnableBinding(value={Processor.class})
public class App2 {

	private final Logger logger =LoggerFactory.getLogger(getClass());
	
	@Bean
	@InboundChannelAdapter(value=Sink.INPUT,poller=@Poller(fixedDelay="2000"))
	public MessageSource<Date> timerMessageSource(){
		return ()->new GenericMessage<>(new Date());
	}
	
	@StreamListener(Processor.INPUT)
	public void receiveFromOutput(Object payload){
		logger.info("Receive : [{}]"+payload);
	}
}
