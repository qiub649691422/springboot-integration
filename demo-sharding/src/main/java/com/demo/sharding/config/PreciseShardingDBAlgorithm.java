/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.demo.sharding.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

public class PreciseShardingDBAlgorithm implements PreciseShardingAlgorithm<Integer> {
    @Override
    public String doSharding(Collection<String> databaseNames,
                             PreciseShardingValue<Integer> shardingValue) {
        for (String each : databaseNames) {
            if (each.endsWith(shardingValue.getValue() % databaseNames.size() + "")) {
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }
}
