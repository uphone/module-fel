package com.rino.fel.interpreter;

import com.rino.fel.context.FelContext;
import com.rino.fel.parser.FelNode;

/**
 * 解析器,用于解析AstNode的值
 * @author yqs
 *
 */
public interface Interpreter {

	/**
	 * @param context
	 * @return
	 */
	Object interpret(FelContext context, FelNode node);

}
