package com.liqiubo.provider.controller;

import com.liqiubo.provider.entity.User;
import com.liqiubo.provider.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Random;

@RestController
@RequestMapping("/provider")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/{id}")
    @HystrixCommand(groupKey = "CircuitBreakerGroupKey",
            commandKey = "CircuitBreakerCommandKey",
            threadPoolKey = "CircuitBreakerThreadPoolKey",
            fallbackMethod = "fallbackMethod",
            threadPoolProperties = {@HystrixProperty(name = "coreSize", value = "200")},
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
                    @HystrixProperty(name = "execution.timeout.enabled", value = "true"),
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "8"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            }
    )
    public User findUser(@PathVariable Long id) {
        try {
            int value = new Random().nextInt(10);
            System.out.println("Random value " + value);
            if (value % 3 != 0) {
                while (true) {
                }
            } else {
                System.out.println("secuss for " + value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userService.findUser(id);
    }

    public User fallbackMethod(Long id) {
        System.out.println("This is fallbackMethod -> " + Thread.currentThread());
        User u = new User();
        u.setId(id);
        u.setUsername("");
        u.setName("");
        u.setAge(Short.valueOf("0"));
        u.setBalance(BigDecimal.ONE);
        return u;
    }
}
