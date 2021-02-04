//package com.rino.fel.function;
//
//import com.rino.fel.function.CommonFunction;
//import com.rino.jdbc.CqlService;
//import com.rino.util.LangUtil;
//import com.rino.util.SpringUtil;
//import lombok.extern.slf4j.Slf4j;
//
//import java.math.BigDecimal;
//
///**
// * 计算个税
// * 用法：calcPsnTax(税前工资)
// *
// * @author zip
// */
//@Slf4j
//public class CalcPsnTaxFunction extends CommonFunction {
//    @Override
//    public Object call(Object[] arguments) {
//        try {
//            if (arguments == null || arguments.length != 1) throw new Exception("参数错误");
//            BigDecimal m1 = LangUtil.toBigDecimal(arguments[0]); // 税前工资
//            BigDecimal m2 = new BigDecimal(5000); //  起征点
//            BigDecimal m3 = m1.subtract(m2); // 差额
//            int i3 = m3.intValue();
//            if (i3 <= 0) return BigDecimal.ZERO;
//            if (i3 <= 3000) return m3.multiply(new BigDecimal(0.03)).subtract(BigDecimal.ZERO).setScale(2, BigDecimal.ROUND_HALF_UP);
//            if (i3 <= 12000) return m3.multiply(new BigDecimal(0.1)).subtract(new BigDecimal(210)).setScale(2, BigDecimal.ROUND_HALF_UP);
//            if (i3 <= 25000) return m3.multiply(new BigDecimal(0.2)).subtract(new BigDecimal(1410)).setScale(2, BigDecimal.ROUND_HALF_UP);
//            if (i3 <= 35000) return m3.multiply(new BigDecimal(0.25)).subtract(new BigDecimal(2660)).setScale(2, BigDecimal.ROUND_HALF_UP);
//            if (i3 <= 55000) return m3.multiply(new BigDecimal(0.3)).subtract(new BigDecimal(4410)).setScale(2, BigDecimal.ROUND_HALF_UP);
//            if (i3 <= 80000) return m3.multiply(new BigDecimal(0.35)).subtract(new BigDecimal(7160)).setScale(2, BigDecimal.ROUND_HALF_UP);
//            return m3.multiply(new BigDecimal(0.45)).subtract(new BigDecimal(15160)).setScale(2, BigDecimal.ROUND_HALF_UP);
//        } catch (Exception ex) {
//            log.error("表达式解析异常", ex);
//        }
//        return null;
//    }
//
//    @Override
//    public String getName() {
//        return "calcPsnTax";
//    }
//}
