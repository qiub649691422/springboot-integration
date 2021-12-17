/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.demo.sharding.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

public class HashCodePreciseAlgorithm implements PreciseShardingAlgorithm {
    @Override
    public String doSharding(Collection availableTargetNames, PreciseShardingValue shardingValue) {
        // hashcode取模分片
        int size = availableTargetNames.size();
        int num = shardingValue.getValue().hashCode() % size;
        String[] list = (String[]) availableTargetNames.toArray(new String[size]);
        if (num <= availableTargetNames.size()) {
            return list[num];
        }
        return null;
    }
}
