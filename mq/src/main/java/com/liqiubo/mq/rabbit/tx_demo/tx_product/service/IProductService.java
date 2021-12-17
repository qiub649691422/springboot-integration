package com.liqiubo.mq.rabbit.tx_demo.tx_product.service;

import com.liqiubo.mq.rabbit.tx_demo.tx_core.entity.Order;
import org.springframework.amqp.core.Message;

import com.rabbitmq.client.Channel;

/**
 * 
 * @author 小五老师
 * @createTime 2018年7月24日 上午11:48:27
 * 
 */
public interface IProductService {
	
	public int updateProduct(Order order) throws Exception;
	public void updateProduct4MQ(Order order, Channel channel, Message message) throws Exception;
}
