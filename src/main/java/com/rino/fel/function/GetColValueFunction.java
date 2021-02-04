//package com.rino.core.fel.function;
//
//import com.rino.core.fel.function.CommonFunction;
//import com.rino.core.jdbc.JdbcQuery;
//import com.rino.core.util.SpringUtil;
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.Map;
//
///**
// * @author zip
// * 用法： getColValue("AMOUNT","FI_PAY","ID",1)
// */
//@Slf4j
//public class GetColValueFunction extends CommonFunction {
//    @Override
//    public Object call(Object[] arguments) {
//        try {
//            if (arguments == null || arguments.length != 4) throw new Exception("参数错误");
//            StringBuilder sql = new StringBuilder("select ");
//            Object arg3 = arguments[3];
//            boolean numFlag = arg3 instanceof Number;
//            sql.append(arguments[0])
//                    .append(" from ")
//                    .append(arguments[1])
//                    .append(" where ")
//                    .append(arguments[2])
//                    .append("=");
//            if (!numFlag) sql.append("'");
//            sql.append(arg3);
//            if (!numFlag) sql.append("'");
//            JdbcQuery jdbcQuery = SpringUtil.getBean(JdbcQuery.class);
//            Map ret = jdbcQuery.queryForObject(sql.toString());
//            if (ret == null) return null;
//            return ret.values().iterator().next();
//        } catch (Exception ex) {
//            log.error("表达式解析异常", ex);
//        }
//        return null;
//    }
//
//    @Override
//    public String getName() {
//        return "getColValue";
//    }
//}
