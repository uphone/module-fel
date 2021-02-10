package com.rino.fel;

import com.rino.fel.context.FelContext;
import com.rino.fel.context.MapContext;
import com.rino.fel.function.ext.NumberFunction;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public final class ExpressUtil {

    private ExpressUtil() {
    }

    public static FelEngine getEngine() {
        FelEngine engine = new FelEngineImpl();
        return engine;
    }

    public static FelEngine getEngine(Object cp, FelContext context) {
        FelEngine engine = getEngine();
        if (context != null) engine.setContext(context);
        setCp(cp, engine);
        return engine;
    }

    public static FelEngine getEngine(Object cp) {
        return getEngine(cp, null);
    }


    // 单次调用
    public static String format(String el) {
        return format(el, null);
    }

    // 单次调用
    public static String format(String el, Object cp) {
        return format(el, cp, null);
    }

    // 单次调用
    public static String format(String el, Object cp, FelContext context) {
        FelEngine engine = getEngine(cp, context);
        return format(engine, el);
    }

    // 多次调用：格式化字符串,包含${}的表达式
    public static String format(FelEngine engine, String el) {
        Pattern regex = Pattern.compile("\\$\\{(.*?)}");
        Matcher matcher = regex.matcher(el);
        StringBuffer ret = new StringBuffer();
        while (matcher.find()) {
            String express = matcher.group();
            String fel = express.substring(0, express.length() - 1).substring(2);
            Object value = parse(engine, fel);
            String str = value == null ? "" : value.toString();
            if ("\\".equals(str)) str = "\\\\";
            if ("$".equals(str)) str = "\\$";
            matcher.appendReplacement(ret, str);
        }
        matcher.appendTail(ret);
        return ret.toString();
    }


    // 单次调用
    public static Object parse(String express) {
        return parse(express, null);
    }

    // 单次调用
    public static Object parse(String express, Object cp) {
        return parse(express, cp, null);
    }

    // 单次调用
    public static Object parse(String express, Object cp, FelContext context) {
        FelEngine engine = getEngine(cp, context);
        return parse(engine, express);
    }

    // 多次调用： 解析表达式（fel), 不包含${}的表达式
    public static Object parse(FelEngine engine, String express) {
        return engine.eval(express);
    }


    @SneakyThrows
    private static void setCp(Object cp, FelEngine engine) {
        if (cp == null) return;
        FelContext context = engine.getContext();
        if (context == null) context = new MapContext();
        engine.setContext(context);
        if (cp instanceof Map) {
            for (Map.Entry<String, Object> e : ((Map<String, Object>) cp).entrySet()) {
                context.set(e.getKey(), e.getValue());
            }
        } else {
            BeanInfo targetBeanInfo = Introspector.getBeanInfo(cp.getClass());
            PropertyDescriptor[] props = targetBeanInfo.getPropertyDescriptors();
            for (PropertyDescriptor prop : props) {
                String propName = prop.getName();
                if ("class".equals(propName)) continue;
                Object value = prop.getReadMethod().invoke(cp);
                context.set(propName, value);
            }
        }
    }
}