/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.liqiubo.consumer.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：liqiubo
 * @description：
 * @date ：2021/9/16 23:31
 */
@NoArgsConstructor
@Data
public class AddressBean {
    /**
     * 地址名称
     */
    @JsonProperty("name")
    private String name;
}
