package com.liqiubo.mq.rabbit.transaction_xa.dao.jta;


import com.liqiubo.mq.rabbit.transaction_xa.model.Order;

public interface OrderDao {
	public void saveOrder(Order order);
}
