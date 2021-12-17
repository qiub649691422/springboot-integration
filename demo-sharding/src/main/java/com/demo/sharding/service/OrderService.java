/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.demo.sharding.service;

import com.demo.sharding.model.Order;
import com.demo.sharding.model.OrderItem;

import java.util.List;

public interface OrderService {

    public List<Order> findHint();

    public void save(Order order, OrderItem item);

}
