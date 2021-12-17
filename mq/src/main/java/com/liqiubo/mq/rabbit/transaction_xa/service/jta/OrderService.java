package com.liqiubo.mq.rabbit.transaction_xa.service.jta;

import com.liqiubo.mq.rabbit.transaction_xa.dao.exp.ReduceStockException;
import com.liqiubo.mq.rabbit.transaction_xa.model.Order;

public interface OrderService {
	public void createOrder(Order order) throws ReduceStockException;
	
	public Integer createOrderByTxTemplate(Order order);
	
	public Integer createOrderByTxManual(Order order);

}
