/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.liqiubo.zookeeper;

import com.liqiubo.zookeeper.controller.Payment;
import com.liqiubo.zookeeper.controller.PaymentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class AppTest {
	@Autowired
	private PaymentService service;

	@Test
	public void test() {
		Payment p = service.getById();
		System.out.println(p.getBrandId() + ", " + p.getProductId() + ", " + p.getPayPrice());
	}
}
