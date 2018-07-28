package com.example.tkmappterTest.config;

import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;


@Configuration
public class RabbitmqConfig {

	    @Bean
	    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory
	    		,Jackson2JsonMessageConverter jackson2JsonMessageConverter) {
	        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
	        factory.setConnectionFactory(connectionFactory);
	        factory.setMessageConverter(jackson2JsonMessageConverter);
	        return factory;
	    }

	    @Bean
	    public SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory){
	            SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
	            container.setConnectionFactory(connectionFactory);
	            container.setMessageListener((MessageListener) message -> {
	                System.out.println("====接收到"+message.getMessageProperties().getConsumerQueue()+"队列的消息=====");
	                System.out.println(message.getMessageProperties());
	                System.out.println(new String(message.getBody()));
	            });
	            return container;
	        }

	    
		@Bean
		public Jackson2JsonMessageConverter jackson2JsonMessageConverter(ObjectMapper xssObjectMapper) {
			return new Jackson2JsonMessageConverter(xssObjectMapper);
		}

	    
	

}
