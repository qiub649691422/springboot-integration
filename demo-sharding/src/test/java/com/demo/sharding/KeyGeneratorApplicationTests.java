/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.demo.sharding;

import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingApplication.class)
public class KeyGeneratorApplicationTests {

    @Test
    public void contextLoads() {
        SnowflakeShardingKeyGenerator keyGenerator = new SnowflakeShardingKeyGenerator();
        for (int i = 0; i < 20; i++) {
            System.out.println(keyGenerator.generateKey());
        }
    }

}

