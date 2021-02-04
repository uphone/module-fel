package com.rino.fel;

import com.rino.fel.context.FelContext;

public interface Expression {
	/**
	 * 求表达式的值
	 * @param arguments
	 * @return
	 */
	Object eval(FelContext context);
	
}
