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
public class StandardShardingApplicationTests {

    @Autowired
    OrderService orderService;

    @Test
    public void contextLoads() {
        Order order = OrderGenerator.generate();
        // ds1
        order.setUserId(15002);
        // t_order0
        order.setOrderId(1314151);
        // ds1.t_order0 t_order_item0
        OrderItem orderItem = ItemGenerator.generate();
        orderItem.setUserId(order.getUserId());
        orderItem.setOrderId(order.getOrderId());
        orderService.save(order, orderItem);
    }

}

