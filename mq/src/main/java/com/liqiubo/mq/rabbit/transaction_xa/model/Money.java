package com.liqiubo.mq.rabbit.transaction_xa.model;

import java.io.Serializable;

public class Money implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private int money;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
}
