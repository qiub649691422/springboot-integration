/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.liqiubo.mq.rabbit.cut.peak.ticket_api.utils;

import com.liqiubo.mq.rabbit.cut.peak.ticket_api.service.ITicketService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(queues=MQProperties.QUEUE_NAME)
public class MQBusiness {

	@Autowired
	private ITicketService ticketService;
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@RabbitHandler
	public void process(String userId){
		String result = ticketService.createTicket(userId);
		amqpTemplate.convertAndSend(MQProperties.EXCHANGE_NAME, MQProperties.ROUTE_KEY_RESP, result);
	}
}
