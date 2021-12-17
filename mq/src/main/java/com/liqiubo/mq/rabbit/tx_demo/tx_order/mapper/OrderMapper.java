package com.liqiubo.mq.rabbit.tx_demo.tx_order.mapper;

import com.liqiubo.mq.rabbit.tx_demo.tx_core.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author 小五老师
 * @createTime 2018年7月24日 上午11:48:27 
 * 
 */
@Mapper
public interface OrderMapper {
	public int insert(Order order);
	public int delete(int orderId);
	public int update(int orderId);
}
