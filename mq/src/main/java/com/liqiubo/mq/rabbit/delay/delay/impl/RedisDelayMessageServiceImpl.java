/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.liqiubo.mq.rabbit.delay.delay.impl;

import com.liqiubo.mq.rabbit.delay.delay.DelayMessageService;
import com.liqiubo.mq.rabbit.delay.utils.CalendarUtils;
import com.liqiubo.mq.rabbit.delay.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 小五老师
 * @createTime 2018年7月22日 下午8:55:32
 * 
 */
@Service("redisDelayMessageServiceImpl")
public class RedisDelayMessageServiceImpl implements DelayMessageService {

	@Autowired
	private RedisUtils redis;
	
	private String key = "DELAY.ORDERID";
	
	//生产者     向集合中添加元素
	public void product(){
		String orderId = "1010101";
		for (int i = 0; i < 10; i++) {
			//创建订单
			redis.addItem4Zset(key, CalendarUtils.getCurrentTimeInMillis(10), orderId+i);
			if(i%3==0){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//消费者   扫描最小元素，判断是否超时
	public void consumer(){
		redis.doFind4Zset(key);
	}
}
