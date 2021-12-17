package com.liqiubo.zookeeper.utils;

import java.security.NoSuchAlgorithmException;

import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

public class ZKDigestTest {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println(DigestAuthenticationProvider.generateDigest("user1:12345"));
	}
}
