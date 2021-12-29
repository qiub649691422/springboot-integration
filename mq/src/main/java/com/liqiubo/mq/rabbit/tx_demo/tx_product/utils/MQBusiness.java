package com.liqiubo.mq.rabbit.tx_demo.tx_product.utils;

import com.liqiubo.mq.rabbit.tx_demo.tx_core.entity.Order;
import com.liqiubo.mq.rabbit.tx_demo.tx_product.service.IProductService;
import org.json.JSONObject;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

@Component
@RabbitListener(queues=MQProperties.QUEUE_NAME_TX)
public class MQBusiness {

	@Autowired
	private IProductService productService;
	
	@RabbitHandler
	public void process(String body, Channel channel, Message message) throws Exception {
		JSONObject obj = new JSONObject(body);
		int orderId = obj.getInt("orderId");
		int productId = obj.getInt("productId");
		int number = obj.getInt("number");
		Order order = new Order();
		order.setOrderId(orderId);
		order.setProductId(productId);
		order.setNumber(number);
		productService.updateProduct4MQ(order, channel, message);
	}

}
