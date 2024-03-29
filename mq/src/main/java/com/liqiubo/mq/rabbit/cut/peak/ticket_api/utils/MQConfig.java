/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.liqiubo.mq.rabbit.cut.peak.ticket_api.utils;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MQConfig {

	//定义任务队列
	@Bean(name="message")
	public Queue queueMessage(){
		Queue queue = new Queue(MQProperties.QUEUE_NAME);
		return queue;
	}
	
	//定义任务回调队列
	@Bean(name="messageResp")
	public Queue queueMessageResp(){
		Queue queue = new Queue(MQProperties.QUEUE_NAME_RESP, true, false, false, null);
		return queue;
	}
	
	//定义任务交换器
	@Bean
	public DirectExchange exchange(){
		return new DirectExchange(MQProperties.EXCHANGE_NAME);
	}
	
	//绑定任务队列与交换器
	@Bean
	public Binding bindingExchangeMessage(@Qualifier("message") Queue queueMessage, DirectExchange exchange){
		return BindingBuilder.bind(queueMessage).to(exchange).with(MQProperties.ROUTE_KEY);
	}

	//绑定任务回调队列与交换器
	@Bean
	public Binding bindingExchangeMessageResp(@Qualifier("messageResp") Queue queueMessage, DirectExchange exchange){
		return BindingBuilder.bind(queueMessage).to(exchange).with(MQProperties.ROUTE_KEY_RESP);
	}
}
