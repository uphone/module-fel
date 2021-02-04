//package com.rino.core.fel.function;
//
//import com.rino.core.fel.function.CommonFunction;
//import com.rino.core.jdbc.CqlService;
//import com.rino.core.util.SpringUtil;
//import lombok.extern.slf4j.Slf4j;
//
///**
// * 用法：executeCQL("cql代码",param)
// *
// * @author zip
// */
//@Slf4j
//public class ExecuteCQLFunction extends CommonFunction {
//    @Override
//    public Object call(Object[] arguments) {
//        try {
//            if (arguments == null || arguments.length != 2) throw new Exception("参数错误");
//            CqlService cqlService = SpringUtil.getBean(CqlService.class);
//            return cqlService.doExecute((String) arguments[0], arguments[1]);
//        } catch (Exception ex) {
//            log.error("表达式解析异常", ex);
//        }
//        return null;
//    }
//
//    @Override
//    public String getName() {
//        return "executeCQL";
//    }
//}
