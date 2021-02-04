//package com.rino.core.fel.function;
//
//import com.rino.core.fel.function.CommonFunction;
//import com.rino.core.util.AmountUtil;
//import com.rino.core.util.LangUtil;
//import lombok.extern.slf4j.Slf4j;
//
//import java.math.BigDecimal;
//
///**
// * 转换为大写金额
// * upperAmount(金额)
// *
// * @author zip
// */
//@Slf4j
//public class UpperAmountFunction extends CommonFunction {
//    @Override
//    public Object call(Object[] arguments) {
//        try {
//            if (arguments == null || arguments.length != 1) throw new Exception("参数错误");
//            BigDecimal m1 = LangUtil.toBigDecimal(arguments[0]);
//            return AmountUtil.toChinese(m1.toString());
//        } catch (Exception ex) {
//            log.error("表达式解析异常", ex);
//        }
//        return null;
//    }
//
//    @Override
//    public String getName() {
//        return "upperAmount";
//    }
//
//}
