package com.liqiubo.client.jedis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Tuple;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @program: redis
 * @description:
 * @create: 2018-11-16 14:01
 **/
public class RedisPool {

    private final JedisPool jedisPool;

    public RedisPool() {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(4);
//
//        poolConfig.setBlockWhenExhausted(true);
//        poolConfig.setMaxWaitMillis(TimeUnit.SECONDS.toMillis(2));
//
        poolConfig.setTimeBetweenEvictionRunsMillis(TimeUnit.SECONDS.toMillis(2));
        poolConfig.setMinEvictableIdleTimeMillis(TimeUnit.SECONDS.toMillis(1));
//
//        poolConfig.setTestOnBorrow(true);
        jedisPool = new JedisPool(poolConfig, "127.0.0.1", 6379);
        Jedis client = null;
        try {
            client = jedisPool.getResource();
            //清空数据库
            client.flushDB();

            Map<String, Double> products = new HashMap<String, Double>();
            products.put("iPhoneX", 6888.00);
            products.put("HUAWEI Mate 20", 4499.00);
            products.put("GalaxyS8+", 4269.00);
            products.put("VIVO x21", 2798.00);
            client.zadd("products", products);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
    }

    public void queryProducts() {
        Jedis client = null;
        try {
            client = jedisPool.getResource();
            Set<Tuple> products = client.zrangeWithScores("products", 0, -1);
            for (Tuple product : products) {
                System.out.println("商品名称:" + product.getElement() + ",价格:" + product.getScore());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            client.close();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        final RedisPool pool = new RedisPool();

        for (int i = 0; i < 15; i++) {
            new Thread(new Runnable() {
                public void run() {
//                    long begin = System.currentTimeMillis();
                    pool.queryProducts();
//                    System.out.println(Thread.currentThread().getName() + "执行时长:" + (System.currentTimeMillis() - begin));
                }
            }, "c-" + i).start();
        }


        Thread.sleep(TimeUnit.SECONDS.toMillis(8));


        for (int i = 0; i < 15; i++) {
            new Thread(new Runnable() {
                public void run() {
                    long begin = System.currentTimeMillis();
                    pool.queryProducts();
                    System.out.println(Thread.currentThread().getName() + "执行时长:" + (System.currentTimeMillis() - begin));
                }
            }, "c-" + i).start();
        }
    }

}
