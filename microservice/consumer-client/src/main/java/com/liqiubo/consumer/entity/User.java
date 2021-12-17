package com.liqiubo.consumer.entity;
import com.google.common.collect.Lists;

import com.google.common.util.concurrent.RateLimiter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class User implements Serializable {

    private Long id;
    private String name;
    private String username;
    private Short age;
    private BigDecimal balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {
        /*RateLimiter limiter = RateLimiter.create(5, 10, TimeUnit.SECONDS);
        int token = 0;
        while (true) {
            System.out.println(limiter.acquire(1) + "  " + (token++));
        }*/

        RateLimiter limiter = RateLimiter.create(1);
        System.out.println(limiter.acquire(10));
        System.out.println(limiter.acquire(1));
        System.out.println(TimeUnit.SECONDS.toMicros(1L));
    }

}
