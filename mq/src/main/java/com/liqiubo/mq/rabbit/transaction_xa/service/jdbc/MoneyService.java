package com.liqiubo.mq.rabbit.transaction_xa.service.jdbc;

public interface MoneyService {
	public void transfer(int fromUser, int toUser, int money) throws Exception;
}
