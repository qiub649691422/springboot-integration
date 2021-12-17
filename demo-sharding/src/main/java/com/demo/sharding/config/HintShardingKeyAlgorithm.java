/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.demo.sharding.config;

import com.alibaba.druid.util.StringUtils;
import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HintShardingKeyAlgorithm implements HintShardingAlgorithm<Integer> {
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames,
                                         HintShardingValue<Integer> shardingValue) {
        System.out.println("shardingValue=" + shardingValue);
        System.out.println("availableTargetNames=" + availableTargetNames);
        List<String> shardingResult = new ArrayList<>();
        for (String targetName : availableTargetNames) {
            String suffix = targetName.substring(targetName.length() - 1);
            if (StringUtils.isNumber(suffix)) {
                Collection<Integer> tmpSharding = shardingValue.getValues();
                for (Integer value : tmpSharding) {
                    // ds0, ds1
                    if (value % 2 == Integer.parseInt(suffix)) {
                        shardingResult.add(targetName);
                    }
                }
            }
        }
        return shardingResult;
    }
}
