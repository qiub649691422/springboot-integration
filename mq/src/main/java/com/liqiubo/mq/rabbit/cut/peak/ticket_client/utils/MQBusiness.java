package com.liqiubo.mq.rabbit.cut.peak.ticket_client.utils;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues=MQProperties.QUEUE_NAME_RESP)
public class MQBusiness {

	@RabbitHandler
	public void process(String message) throws Exception {
		System.out.println(message);
	}

}
