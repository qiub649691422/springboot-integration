package com.liqiubo.mq.rabbit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Address;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.GetResponse;
import com.rabbitmq.client.MessageProperties;
import com.rabbitmq.client.ShutdownSignalException;

/**
 * 
 * @author liqiubo
 * @createTime 2018年9月4日 下午2:44:30
 * 消费者客户端
 */
public class RabbitConsumer {
	private static final String QUEUE_NAME = "demo.queue.queue"; //队列
	private static final String IP_ADDRESS="192.168.110.130";
	private static final int PORT=5672;
	
	public static void push() throws Exception {
		Address[] addresses = new Address[]{new Address(IP_ADDRESS, PORT)};
		ConnectionFactory factory = new ConnectionFactory();
		factory.setUsername("rabbitstudy");
		factory.setPassword("123456");
		//这里的连接方式与生产者的略有不同，注意辨别区别
		Connection connection = factory.newConnection(addresses); //创建连接
		final Channel channel = connection.createChannel(); //创建信道
		channel.basicQos(2);  	// 设置未被确认消费的个数，未被确认之前，不允许发送消息超过该数目给这个消费者/用来限流
		Consumer consumer = new DefaultConsumer(channel){
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
					throws IOException {
				System.out.println("recv message:"+ new String(body));
				System.out.println("RoutingKey:"+envelope.getRoutingKey());
				System.out.println("ContentType:"+properties.getContentType());
				System.out.println("DeliveryTag:"+envelope.getDeliveryTag()); //消息在队列中的下标
				System.out.println("------------------------------");
				// deleveryTag 消息的顺序id。  mutiple true确认消费了该条消息，false确认消费了当前channel该id前的所有消息，批量确认
				channel.basicAck(envelope.getDeliveryTag(), false);  // 告诉了mq消费类消息，消息确认机制
			}
		};
		channel.basicConsume(QUEUE_NAME, false, consumer); //设置autoAck为false
		
		//等待回调行数执行完毕之后，关闭资源
		channel.close();
		connection.close();
	}
	
	public static void pull() throws Exception {
		Address[] addresses = new Address[]{new Address(IP_ADDRESS, PORT)};
		ConnectionFactory factory = new ConnectionFactory();
		factory.setUsername("rabbitstudy");
		factory.setPassword("123456");
		
		//这里的连接方式与生产者的略有不同，注意辨别区别
		Connection connection = factory.newConnection(addresses); //创建连接
		final Channel channel = connection.createChannel(); //创建信道
		channel.basicQos(10);
		GetResponse basicGet = channel.basicGet(QUEUE_NAME, false);
		System.out.println(new String(basicGet.getBody()));
		
		channel.basicAck(basicGet.getEnvelope().getDeliveryTag(), true); //确认消费完成
		
		//等待回调行数执行完毕之后，关闭资源
//		channel.close();
//		connection.close();
	}
	
	public static void reject() throws Exception {
		Address[] addresses = new Address[]{new Address(IP_ADDRESS, PORT)};
		ConnectionFactory factory = new ConnectionFactory();
		factory.setUsername("rabbitstudy");
		factory.setPassword("123456");
		
		//这里的连接方式与生产者的略有不同，注意辨别区别
		Connection connection = factory.newConnection(addresses); //创建连接
		final Channel channel = connection.createChannel(); //创建信道
		
		GetResponse basicGet = channel.basicGet(QUEUE_NAME, false);
		System.out.println(new String(basicGet.getBody()));
		
		channel.basicReject(basicGet.getEnvelope().getDeliveryTag(), true);
		
		//等待回调行数执行完毕之后，关闭资源
		channel.close();
		connection.close();
	}
	
	public static void main(String[] args) throws Exception {
//		ConnectionFactory factory = new ConnectionFactory(); //连接工厂  
//		//配置连接参数  信息
//		factory.setUsername("rabbitstudy");
//		factory.setPassword("123456");
//		factory.setHost("192.168.110.130");
//		factory.setPort(5672);
//		Connection connection = factory.newConnection(); //创建连接
//		final Channel channel = connection.createChannel(); //创建信道 在信道上传递消息
//		for (int i = 0; i < 10; i++) {
//			channel.basicPublish("demo.exchange", "Five", 
//					MessageProperties.PERSISTENT_TEXT_PLAIN, 
//					("Hello "+i).getBytes());
//		}
//		channel.close();
//		connection.close();
		
//		push(); //推模式
//		pull(); //拉模式
		reject(); //reject拒绝消息
	}
}
