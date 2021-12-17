/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.demo.sharding.config;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class RangeShardingTableAlgorithm implements RangeShardingAlgorithm<Integer> {

    @Override
    public Collection<String> doSharding(final Collection<String> tableNames,
                                         final RangeShardingValue<Integer> shardingValue) {
        Set<String> result = new LinkedHashSet<>();
        if (Range.closed(2000000,
                7000000).encloses(shardingValue.getValueRange())) {
            for (String each : tableNames) {
                if (each.endsWith("0")) {
                    result.add(each);
                }
            }
        } else {
            throw new UnsupportedOperationException();
        }
        return result;
    }

}
