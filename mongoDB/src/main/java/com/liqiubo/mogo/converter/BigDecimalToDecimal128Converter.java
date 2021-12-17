package com.liqiubo.mogo.converter;

import java.math.BigDecimal;

import org.bson.types.Decimal128;
import org.springframework.core.convert.converter.Converter;

public class BigDecimalToDecimal128Converter implements Converter<BigDecimal, Decimal128> {
	 
    public Decimal128 convert(BigDecimal source) {
        return new Decimal128(source);
    }
}
