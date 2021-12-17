/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.demo.sharding;

import com.demo.sharding.model.ItemGenerator;
import com.demo.sharding.model.Order;
import com.demo.sharding.model.OrderGenerator;
import com.demo.sharding.model.OrderItem;
import com.demo.sharding.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingApplication.class)
public class ComplexShardingApplicationTests {
    @Autowired
    private OrderService orderService;

    @Test
    public void test() {
//        Order order = OrderGenerator.generate();
//        order.setUserId(10000011);
//        order.setOrderId(1000010);
//        OrderItem orderItem = ItemGenerator.generate();
//        orderItem.setUserId(order.getUserId());
//        orderItem.setOrderId(order.getOrderId());

        Order order1 = OrderGenerator.generate();
        order1.setUserId(10000066);
        order1.setOrderId(1000077);
        OrderItem orderItem1 = ItemGenerator.generate();
        orderItem1.setUserId(order1.getUserId());
        orderItem1.setOrderId(order1.getOrderId());

//        Order order2 = OrderGenerator.generate();
//        order2.setUserId(10000044);
//        order2.setOrderId(1000055);
//        OrderItem orderItem2 = ItemGenerator.generate();
//        orderItem2.setUserId(order.getUserId());
//        orderItem2.setOrderId(order2.getOrderId());
//        orderService.save(order2, orderItem);
        orderService.save(order1, orderItem1);
        //orderService.save(order2, orderItem2);
    }
}
