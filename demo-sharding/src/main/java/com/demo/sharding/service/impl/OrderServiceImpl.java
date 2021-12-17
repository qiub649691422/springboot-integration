/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.demo.sharding.service.impl;

import com.demo.sharding.mapper.OrderItemMapper;
import com.demo.sharding.mapper.OrderMapper;
import com.demo.sharding.model.Order;
import com.demo.sharding.model.OrderItem;
import com.demo.sharding.service.OrderService;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @ShardingTransactionType(TransactionType.BASE)
    public void save(Order order, OrderItem item) {
        orderMapper.save(order);
        orderItemMapper.save(item);
    }

    @Override
    public List<Order> findHint() {
        return orderMapper.selectHint();
    }
}
