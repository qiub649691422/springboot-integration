package com.liqiubo.mq.rabbit.exchangeType;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * 
 * fanout类型交换器：把所有发送到该交换器的消息路由到所有与该交换器绑定的队列中
 */
public class RabbitProducterByFanout {

	private static final String EXCHANGE_NAME = "demo.exchange"; //交换器名称
	private static final String ROUTING_KEY1 = "demo.routingkey1"; //路由键1
	private static final String ROUTING_KEY2 = "demo.routingkey2"; //路由键2
	private static final String QUEUE_NAME1 = "demo.exchange.queue1"; //队列1
	private static final String QUEUE_NAME2 = "demo.exchange.queue2"; //队列2
	private static final String IP_ADDRESS = "192.168.110.130";
	private static final int PORT = 5672;//RabbitMQ 服务端默认端口号为 5672
	
	public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(IP_ADDRESS);
		factory.setPort(PORT);
		factory.setUsername("rabbitstudy");
		factory.setPassword("123456");
		Connection connection = factory.newConnection();//创建连接
		Channel channel = connection.createChannel();//创建信道
		//创建一个 type="fanout" 的交换器
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout" , true , false , null);
		//创建两个队列
		channel.queueDeclare(QUEUE_NAME1, true, false , false , null);
		channel.queueDeclare(QUEUE_NAME2, true, false , false , null);
		//将交换器与队列通过路由键绑定
		channel.queueBind(QUEUE_NAME1 , EXCHANGE_NAME , ROUTING_KEY1);
		channel.queueBind(QUEUE_NAME2 , EXCHANGE_NAME , ROUTING_KEY2);
		for (int i = 0; i < 10; i++) {
			String message = "Number:"+i;
			channel.basicPublish(EXCHANGE_NAME, i%2==0?ROUTING_KEY1:ROUTING_KEY2,
					MessageProperties.PERSISTENT_TEXT_PLAIN,
					message.getBytes());
		}
		//关闭资源
		channel.close();
		connection.close();
	}
}
