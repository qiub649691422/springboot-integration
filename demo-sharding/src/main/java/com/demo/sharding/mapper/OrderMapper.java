/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.demo.sharding.mapper;

import com.demo.sharding.model.Order;

import java.util.List;

public interface OrderMapper {
    public int save(Order order);

    public List<Order> selectHint();
}
