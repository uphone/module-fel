package com.rino.fel.compile;

import com.rino.fel.Expression;

public interface FelCompiler {
	
	/**
	 * 
	 * 编译代码，并创建Expression
	 * @param expr
	 * @return
	 */
	public Expression compile(JavaSource src);

}
