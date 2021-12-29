package com.liqiubo.mq.rabbit.tx_demo.tx_product.mapper;

import com.liqiubo.mq.rabbit.tx_demo.tx_core.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
	public int update(Order order);
}
