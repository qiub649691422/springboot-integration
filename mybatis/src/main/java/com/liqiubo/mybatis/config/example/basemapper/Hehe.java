/*
 * <P> Copyright (c) 2020. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.liqiubo.mybatis.config.example.basemapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.liqiubo.mybatis.entity.Animal;
import com.liqiubo.mybatis.entity.Bird;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author ：liqiubo
 * @description：
 * @date ：2020/2/28 1:27
 */
public class Hehe {

    private static Object test() {
        TypeReference<Animal<List<Bird>>> typeReference = new TypeReference<Animal<List<Bird>>>() {};
        Type type = typeReference.getType();
        return type;
    }

    public static void main(String[] args) {
        System.out.println(test1());
//        System.out.println(test());

    }

    private static Object test1() {
        Animal<List<Bird>> bird = new Animal<>();
        Type genericSuperclass = bird.getClass().getGenericSuperclass();
        return genericSuperclass;
    }
}
