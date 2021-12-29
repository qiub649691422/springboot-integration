package com.liqiubo.mq.rabbit.tx_demo.tx_product.service;

import com.liqiubo.mq.rabbit.tx_demo.tx_core.entity.Order;
import org.springframework.amqp.core.Message;

import com.rabbitmq.client.Channel;

public interface IProductService {
	
	public int updateProduct(Order order) throws Exception;
	public void updateProduct4MQ(Order order, Channel channel, Message message) throws Exception;
}
