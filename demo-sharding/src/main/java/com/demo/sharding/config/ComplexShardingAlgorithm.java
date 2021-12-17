/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.demo.sharding.config;

import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ComplexShardingAlgorithm implements ComplexKeysShardingAlgorithm<Integer> {
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames,
                                         ComplexKeysShardingValue<Integer> shardingValues) {
        {
            System.out.println("collection:" + availableTargetNames + ",shardingValues:" + shardingValues);
            Collection<Integer> orderIdValues = getShardingValue(shardingValues, "order_id");
            Collection<Integer> userIdValues = getShardingValue(shardingValues, "user_id");
            List<String> shardingSuffix = new ArrayList<>();

            // user_id，order_id分片键进行分表
            for (Integer userId : userIdValues) {
                for (Integer orderId : orderIdValues) {
                    String suffix = userId % 2 + "_" + orderId % 2;
                    for (String s : availableTargetNames) {
                        if (s.endsWith(suffix)) {
                            shardingSuffix.add(s);
                        }
                    }
                }
            }
            return shardingSuffix;
        }

    }

    private Collection<Integer> getShardingValue(ComplexKeysShardingValue<Integer> shardingValues,
                                                 final String key) {
        Map<String, Collection<Integer>> map = shardingValues.getColumnNameAndShardingValuesMap();
        return map.get(key);
    }
}
