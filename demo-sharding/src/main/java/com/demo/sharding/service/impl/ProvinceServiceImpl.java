/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.demo.sharding.service.impl;

import com.demo.sharding.mapper.ProvinceMapper;
import com.demo.sharding.model.Province;
import com.demo.sharding.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceMapper provinceMapper;

    @Override
    public void save(Province province) {
        provinceMapper.save(province);
    }
}
