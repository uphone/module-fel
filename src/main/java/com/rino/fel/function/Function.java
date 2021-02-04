package com.rino.fel.function;

import com.rino.fel.context.FelContext;
import com.rino.fel.compile.SourceBuilder;
import com.rino.fel.parser.FelNode;

public interface Function {

    /**
     * 获取函数的名称
     *
     * @return
     */
    String getName();

    /**
     * 调用函数
     *
     * @param arguments
     * @return
     */
    Object call(FelNode node, FelContext context);


    SourceBuilder toMethod(FelNode node, FelContext ctx);


}
