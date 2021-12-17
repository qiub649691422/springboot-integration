/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.demo.sharding.config;

import org.apache.shardingsphere.core.strategy.keygen.TimeService;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;

import java.util.Properties;

public class HashKeyGenerator implements ShardingKeyGenerator {
    private Properties properties = new Properties();

    @Override
    public String getType() {
        return "HASH";
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }

    @Override
    public Comparable<Long> generateKey() {
        Long time = new TimeService().getCurrentMillis();
        long key = time.hashCode() < 0 ? time.hashCode() >>> 1 : time.hashCode();
        return key;
    }

    public static void main(String[] args) {
        HashKeyGenerator hashKeyGenerator = new HashKeyGenerator();
        System.out.println(hashKeyGenerator.generateKey());
    }
}
