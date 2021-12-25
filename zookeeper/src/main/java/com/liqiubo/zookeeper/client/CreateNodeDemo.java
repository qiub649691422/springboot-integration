package com.liqiubo.zookeeper.client;

import org.I0Itec.zkclient.ZkClient;

public class CreateNodeDemo {
	public static void main(String[] args) {
		ZkClient client = new ZkClient("192.168.1.129:2181", 5000);
		String path = "/zk-client/c1";
		// 递归创建节点
		client.createPersistent(path, true);
	}
}
