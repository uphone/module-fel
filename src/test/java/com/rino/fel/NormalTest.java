package com.rino.fel;

import com.rino.fel.context.FelContext;
import com.rino.fel.context.MapContext;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

public class NormalTest {
    @SneakyThrows
    public static void main(String[] args) {
        FelEngine engine = new FelEngineImpl();
        Map map = new HashMap();
        map.put("name", "张三");
        FelContext context = new MapContext(map);
        engine.setContext(context);
        Object ret = engine.eval("name");
        System.out.println(ret);
    }
}

