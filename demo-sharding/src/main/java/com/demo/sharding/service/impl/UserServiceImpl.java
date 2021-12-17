/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.demo.sharding.service.impl;

import com.demo.sharding.mapper.UserMapper;
import com.demo.sharding.model.User;
import com.demo.sharding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(User user) {
        userMapper.save(user);
    }

    @Override
    public List<User> getUser() {
        return userMapper.getUsers();
    }
}
