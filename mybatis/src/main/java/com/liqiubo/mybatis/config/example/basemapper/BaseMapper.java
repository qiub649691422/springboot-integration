package com.liqiubo.mybatis.config.example.basemapper;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @InsertProvider(type = UseGeneratedKeysSelectiveProvider.class, method = "dynamicSQL")
    int insertUseGeneratedKeysSelective(T t);
}