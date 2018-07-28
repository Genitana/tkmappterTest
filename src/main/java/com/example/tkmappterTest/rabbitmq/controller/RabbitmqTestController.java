package com.example.tkmappterTest.rabbitmq.controller;

import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RabbitmqTestController {

	@Autowired
	private SimpleMessageListenerContainer messageListenerContainer  ;
	
	@RequestMapping("/add")
	public String addQueue(String queueName) {
		messageListenerContainer.addQueueNames(queueName);
		System.out.println("添加监听队列:"+queueName+" 成功");
		return "success";
	}
	@RequestMapping("/remove")
	public String removeQueue(String queueName) {
		messageListenerContainer.removeQueueNames(queueName);
		System.out.println("移除队列:"+queueName+"成功");
		return "success";
	}
}