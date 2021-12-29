package com.liqiubo.mq.rabbit.tx_demo.tx_order.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

@Component
public class MQClientInfo {
	
	@Value("${spring.rabbitmq.host}")
	public String IP_ADDRESS;
	@Value("${spring.rabbitmq.port}")
	public int PORT;
	@Value("${spring.rabbitmq.username}")
	public String USERNAME;
	@Value("${spring.rabbitmq.password}")
	public String PASSWORD;
	

	public ConnectionFactory factory = new ConnectionFactory();
	public Connection connection = null;

	public Connection getConnection() throws Exception {
		factory.setHost(IP_ADDRESS) ;
		factory.setPort(PORT) ;
		factory.setUsername(USERNAME);
		factory.setPassword(PASSWORD);
		return factory.newConnection();//创建连接
	}
}
