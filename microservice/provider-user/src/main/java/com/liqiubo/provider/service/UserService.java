package com.liqiubo.provider.service;

import com.liqiubo.provider.dao.UserDao;
import com.liqiubo.provider.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User findUser(Long id){
        return userDao.findOne(id);
    }
}
