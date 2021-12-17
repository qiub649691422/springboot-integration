/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.liqiubo.consumer.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ：liqiubo
 * @description：
 * @date ：2021/9/16 21:07
 */
@NoArgsConstructor
@Data
public class Address {
    /**
     * id
     */
    @JsonProperty("id")
    private Integer id;
    /**
     * 名称
     */
    @JsonProperty("name")
    private String name;
    /**
     * 地址
     */
    @JsonProperty("address")
    private List<AddressBean> address;
}



