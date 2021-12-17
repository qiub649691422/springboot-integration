/*
 * <P> Copyright (c) 2020. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.liqiubo.mybatis.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Integer id;
    private String name;
    private String phone;
    private String address;
}
