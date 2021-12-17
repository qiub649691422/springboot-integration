/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.demo.sharding.config;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class RangeShardingDBAlgorithm implements RangeShardingAlgorithm<Integer> {
    @Override
    public Collection<String> doSharding(final Collection<String> databaseNames,
                                         final RangeShardingValue<Integer> shardingValue) {
        Set<String> result = new LinkedHashSet<>();
        int lower = shardingValue.getValueRange().lowerEndpoint();
        int upper = shardingValue.getValueRange().upperEndpoint();
        for (int i = lower; i <= upper; i++) {
            for (String each : databaseNames) { //ds0,ds1
                if (each.endsWith(i % databaseNames.size() + "")) {
                    result.add(each);
                }
            }
        }
        return result;
    }
}
