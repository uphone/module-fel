package com.rino.fel.function;

import java.math.BigDecimal;

/**
 * @author zip
 * 用法： number("123.126",2) 不传递小数位数，则不做小数位数的处理, 返回double值
 */
public class NumberFunction extends CommonFunction {
    @Override
    public Object call(Object[] arguments) {
        int scale = arguments.length == 2 ? (Integer) arguments[1] : -1;
        BigDecimal value = new BigDecimal(arguments[0].toString());
        if (scale == -1) return value.doubleValue();
        if (scale == 0) return value.intValue();
        return value.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    @Override
    public String getName() {
        return "number";
    }
}
