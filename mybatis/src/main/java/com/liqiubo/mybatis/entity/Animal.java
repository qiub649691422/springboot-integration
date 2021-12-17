/*
 * <P> Copyright (c) 2020. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.liqiubo.mybatis.entity;

import lombok.Data;

import java.util.List;

/**
 * @author ：liqiubo
 * @description：
 * @date ：2020/6/26 19:29
 */
@Data
public class Animal<T> {

    private String name;

    private String sex;

    private List<String> ages;

    private T type;

}
