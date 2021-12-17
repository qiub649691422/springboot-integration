package com.liqiubo.mq.rabbit.transaction_xa.dao.jdbc;

public interface MoneyDao {
	//加钱操作
	public int increase(int id, int money);

	//减钱操作
	public int decrease(int id, int money) throws Exception;
}
