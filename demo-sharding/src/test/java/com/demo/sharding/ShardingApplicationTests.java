/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.demo.sharding;

import com.demo.sharding.model.User;
import com.demo.sharding.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingApplication.class)
public class ShardingApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setName("wangwu");
        userService.save(user);
    }

}

