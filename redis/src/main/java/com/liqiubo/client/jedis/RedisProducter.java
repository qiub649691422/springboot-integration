package com.liqiubo.client.jedis;

import redis.clients.jedis.Jedis;

/**
 * @program: redis
 * @description:
 * @create: 2018-11-16 11:14
 **/
public class RedisProducter {

    public void product(){
        Jedis client = new Jedis("127.0.0.1", 6379);
        client.publish("news.sport", "英超最新战报 曼联1-3曼城");
        client.publish("news.game", "网易暴雪合作手游《暗黑》明年上市");
        client.publish("news.weather", "上海11.17日 晴转多云 13~16℃");
        client.publish("news.sport", "close");
    }

    public static void main(String[] args) {

       RedisProducter producter = new RedisProducter();
       producter.product();

    }
}
