package com.rino.fel.function.ext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rino.fel.function.CommonFunction;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author zip
 * 用法： json(xx) 如果参数为字符串,则转换为对象, 否则转换为字符串
 */
public class JsonFunction extends CommonFunction {
    @SneakyThrows
    @Override
    public Object call(Object[] arguments) {
        Object arg0 = arguments[0];
        ObjectMapper mapper = new ObjectMapper();
        if (arg0 instanceof String) {
            if (((String) arg0).startsWith("[")) return mapper.readValue((String) arg0, ArrayList.class);
            else return mapper.readValue((String) arg0, HashMap.class);
        } else {
            return mapper.writeValueAsString(arg0);
        }
    }

    @Override
    public String getName() {
        return "json";
    }
}
