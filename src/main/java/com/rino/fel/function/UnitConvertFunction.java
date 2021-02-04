//package com.rino.core.fel.function;
//
//import com.rino.core.fel.function.CommonFunction;
//import com.rino.core.util.LangUtil;
//import com.rino.core.util.UnitUtil;
//import lombok.extern.slf4j.Slf4j;
//
//import java.math.BigDecimal;
//
///**
// * @author zip
// * 单位换算
// * 用法： UnitConvert(1,"KG","T") => 1KG等于多少T
// */
//@Slf4j
//public class UnitConvertFunction extends CommonFunction {
//
//    @Override
//    public Object call(Object[] arguments) {
//        try {
//            if (arguments == null || arguments.length != 3) throw new Exception("参数错误");
//            String unitFrom = (String) arguments[1], unitTo = (String) arguments[2];
//            BigDecimal valueFrom = LangUtil.toBigDecimal(arguments[0]);
//            if (unitFrom.equalsIgnoreCase(unitTo)) return valueFrom;
//            BigDecimal hsl = UnitUtil.getHsl(unitFrom, unitTo);
//            BigDecimal valueTo = valueFrom.multiply(hsl);
//            return valueTo;
//        } catch (Exception ex) {
//            log.error("表达式解析异常", ex);
//        }
//        return null;
//    }
//
//    @Override
//    public String getName() {
//        return "UnitConvert";
//    }
//}
