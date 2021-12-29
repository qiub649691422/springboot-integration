/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.liqiubo.hystrix;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;

@Component
public class HystrixCacheService {

	@CacheResult(cacheKeyMethod="getCacheKey")
    @HystrixCommand(
    		groupKey = "CacheGroupKey",
            commandKey = "CacheCommandKey",
            threadPoolKey = "CacheThreadPoolKey")
    public String randomMethod(int max){
        Random random = new Random();
        int nextInt = random.nextInt(max);
        System.out.println("nextInt:"+nextInt);
		return nextInt+"";
    }
    
    public String getCacheKey(int max){
    	return "cache-"+max;
    }
}
