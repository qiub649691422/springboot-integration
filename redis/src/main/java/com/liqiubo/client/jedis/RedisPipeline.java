package com.liqiubo.client.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.util.List;

/**
 * @program: redis
 * @description:
 * @create: 2018-11-16 15:18
 **/
public class RedisPipeline {


    public void follow(long userId, String... shops) {
        Jedis client = new Jedis("127.0.0.1", 6379);
        client.flushDB();

        Pipeline pipeline = client.pipelined();
        for (String shop : shops) {
            pipeline.sadd("follow:shop:" + userId, shop);
        }
        List<Object> results = pipeline.syncAndReturnAll();
        for (Object result : results) {
            System.out.println(result);
        }
    }


    public void follow(long userId, String shop) {
        Jedis client = new Jedis("127.0.0.1", 6379);
        client.flushDB();


        Pipeline pipeline = client.pipelined();
        pipeline.multi();
        pipeline.sadd("follow:shop:" + userId, shop);
        pipeline.sadd("followed:" + shop, String.valueOf(userId));
        Response<List<Object>> response =  pipeline.exec();

        List<Object> results = pipeline.syncAndReturnAll();

        for (Object o : response.get()) {
            System.out.println("事务执行:"+o);
        }
        for (Object result : results) {
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        RedisPipeline pipeline = new RedisPipeline();
//        pipeline.follow(1, "美邦正品折扣店", "天梭腕表京东自营专区", "Aptamil爱他美官方海外旗舰店");
        pipeline.follow(1, "philips");
    }
}
