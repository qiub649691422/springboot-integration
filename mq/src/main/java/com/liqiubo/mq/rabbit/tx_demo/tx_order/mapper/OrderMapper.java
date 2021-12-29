package com.liqiubo.mq.rabbit.tx_demo.tx_order.mapper;

import com.liqiubo.mq.rabbit.tx_demo.tx_core.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
	public int insert(Order order);
	public int delete(int orderId);
	public int update(int orderId);
}
