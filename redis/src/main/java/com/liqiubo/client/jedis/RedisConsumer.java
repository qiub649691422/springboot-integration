package com.liqiubo.client.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * @program: redis
 * @description:
 * @create: 2018-11-16 11:14
 **/
public class RedisConsumer extends JedisPubSub {

    // 接收订阅信息事件处理
    public void onMessage(String channel, String message) {
        //收到close消息后取消订阅
        if("close".equals(message)){
            this.unsubscribe(channel);
        }
        System.out.println(Thread.currentThread().getName() + "收到来自" + channel + "发布的消息:" + message);
    }

    // 订阅事件处理
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println(Thread.currentThread().getName() + "成功订阅" + channel + ",总共订阅频道数:" + subscribedChannels);
    }

    // 取消订阅事件处理
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println(Thread.currentThread().getName() + "取消订阅" + channel + ",总共订阅频道数:" + subscribedChannels);
    }

    // 模式订阅事件处理
    public void onPSubscribe(String pattern, int subscribedChannels) {
        System.out.println(Thread.currentThread().getName() + "成功订阅模式位" + pattern + "所有频道,总共订阅模式频道数:" + subscribedChannels);
    }

    // 取消模式订阅事件处理
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        System.out.println(Thread.currentThread().getName() + "取消订阅模式" + pattern + ",总共订阅模式频道数:" + subscribedChannels);
    }

    // 接收模式订阅信息事件处理
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println(Thread.currentThread().getName() + "收到来自" + channel + "发布的消息:" + message);
    }

    public void consume(String... channel) {
        Jedis client = new Jedis("127.0.0.1", 6379);
        client.subscribe(this, channel);
    }

    public void pConsume(String... channel) {
        Jedis client = new Jedis("127.0.0.1", 6379);
        client.psubscribe(this, channel);
    }


    public static void main(String[] args) {

//        new Thread(new Runnable() {
//            public void run() {
//                RedisConsumer consumer = new RedisConsumer();
//                consumer.consume("news.sport","news.weather");
//            }
//        },"张三").start();
//
//        new Thread(new Runnable() {
//            public void run() {
//                RedisConsumer consumer = new RedisConsumer();
//                consumer.consume( "news.game");
//            }
//        },"李四").start();
        final RedisConsumer consumer = new RedisConsumer();
        new Thread(new Runnable() {
            public void run() {
                consumer.consume("news.sport");
            }
        }, "王五").start();

    }
}
