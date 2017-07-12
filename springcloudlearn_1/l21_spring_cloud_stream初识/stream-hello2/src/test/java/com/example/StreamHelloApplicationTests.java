package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.iface.SinkSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamHelloApplicationTests {

	//注入SinkSender实例
	@Autowired
	SinkSender sinkSender;

	//注入消息通道
	@Autowired
	MessageChannel input;
	
	//@Test
	public void test01() {
		sinkSender.output().send(MessageBuilder.withPayload("FROM SinkSender").build());
	}
	
	@Test
	public void test02() {
		input.send(MessageBuilder.withPayload("FROM SinkSender").build());
	}

}
