package com.liqiubo.zookeeper.registry;

public class HelloServiceImpl implements HelloService {
	public String hello(String name) {
		return "hello " + name;
	}
}
