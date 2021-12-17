package com.liqiubo.mq.rabbit.tx_demo.tx_product.mapper;

import com.liqiubo.mq.rabbit.tx_demo.tx_core.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author 小五老师
 * @createTime 2018年7月24日 上午11:48:27 
 * 
 */
@Mapper
public interface ProductMapper {
	public int update(Order order);
}
