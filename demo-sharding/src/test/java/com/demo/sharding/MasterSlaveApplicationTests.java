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

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingApplication.class)
public class MasterSlaveApplicationTests {
    @Autowired
    private UserService userService;

    // 在主库上插入
    @Test
    public void test1() {
        User u = new User();
        u.setName("lisi");
        u.setId(4);
        userService.save(u);
    }

    // 从slave库上读取

    public void test2() {
        List<User> list = userService.getUser();
        System.out.println(list.get(0).getName());
    }
}
