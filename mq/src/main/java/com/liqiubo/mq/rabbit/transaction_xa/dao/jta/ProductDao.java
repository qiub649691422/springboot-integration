package com.liqiubo.mq.rabbit.transaction_xa.dao.jta;

import com.liqiubo.mq.rabbit.transaction_xa.dao.exp.ReduceStockException;

public interface ProductDao {
	public int reduceStock(Integer productId, Integer amount) throws ReduceStockException;
}
