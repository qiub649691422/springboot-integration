package com.liqiubo.zookeeper.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class CreateSessionDemo {
	public static void main(String[] args) throws InterruptedException {
		RetryPolicy policy = new ExponentialBackoffRetry(1000, 3);
		CuratorFramework client = CuratorFrameworkFactory.builder().connectString("192.168.56.101:2181")
				.sessionTimeoutMs(5000).retryPolicy(policy).build();
		client.start();
		Thread.sleep(Integer.MAX_VALUE);
	}
}
