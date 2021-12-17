/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.demo.sharding.mapper;

import com.demo.sharding.model.User;

import java.util.List;

public interface UserMapper {
    public int save(User user);

    public List<User> getUsers();
}
