//package com.rino.core.fel.function;
//
//import com.rino.core.fel.function.CommonFunction;
//import com.rino.core.util.LangUtil;
//import lombok.extern.slf4j.Slf4j;
//
//import java.math.BigDecimal;
//
///**
// * 计算五险一金
// * 用法：calcWXYJ(社保基数,[公积金基数])
// * 返回值: [社保个人、社保公司、公积金个人、公积金公司]
// *
// * @author zip
// */
//@Slf4j
//public class CalcWXYJFunction extends CommonFunction {
//    @Override
//    public Object call(Object[] arguments) {
//        try {
//            if (arguments == null) throw new Exception("参数错误");
//            BigDecimal s1 = LangUtil.toBigDecimal(arguments[0]); // 社保基数
//            BigDecimal s2 = s1.multiply(new BigDecimal("0.08")); // 养老-个人
//            BigDecimal s3 = s1.multiply(new BigDecimal("0.16")); // 养老-公司
//            BigDecimal s4 = s1.multiply(new BigDecimal("0.02")); // 医疗-个人
//            BigDecimal s5 = s1.multiply(new BigDecimal("0.095")); // 医疗-公司
//            BigDecimal s6 = s1.multiply(new BigDecimal("0.005")); // 失业-个人
//            BigDecimal s7 = s1.multiply(new BigDecimal("0.005")); // 失业-公司
//            BigDecimal s8 = BigDecimal.ZERO; // 工伤-个人
//            BigDecimal s9 = s1.multiply(new BigDecimal("0.0026")); // 工伤-公司
//            BigDecimal s10 = BigDecimal.ZERO; // 生育-个人
//            BigDecimal s11 = s1.multiply(new BigDecimal("0.001")); // 生育-公司
//            BigDecimal sa = s2.add(s4).add(s6).add(s8).add(s10); // 社保-个人部分
//            BigDecimal sb = s3.add(s5).add(s7).add(s9).add(s11); // 社保-公司部分
//            if (arguments.length == 1) return new BigDecimal[]{sa, sb};
//            BigDecimal t1 = LangUtil.toBigDecimal(arguments[1]); // 公积金基数
//            BigDecimal t2 = t1.multiply(new BigDecimal("0.07"));
//            BigDecimal t3 = t1.multiply(new BigDecimal("0.07"));
//            return new BigDecimal[]{sa, sb, t2, t3};
//        } catch (Exception ex) {
//            log.error("表达式解析异常", ex);
//        }
//        return null;
//    }
//
//    @Override
//    public String getName() {
//        return "calcWXYJ";
//    }
//}
