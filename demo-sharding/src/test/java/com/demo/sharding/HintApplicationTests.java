/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.demo.sharding;

import com.demo.sharding.service.OrderService;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingApplication.class)
public class HintApplicationTests {
    @Autowired
    private OrderService orderService;

    @Test
    public void test() {
        HintManager.clear();
        HintManager hintManager = HintManager.getInstance();
        hintManager.addDatabaseShardingValue("t_order", 1);
        hintManager.addTableShardingValue("t_order", 1);
        System.out.println(orderService.findHint());
    }
}
