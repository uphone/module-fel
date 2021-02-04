package com.rino.fel.compile;

import com.rino.fel.context.FelContext;
import com.rino.fel.optimizer.Optimizer;
import com.rino.fel.parser.FelNode;

public interface SourceGenerator {
	
	/**
	 * 获取表达式JAVA源代码
	 * @param node TODO
	 * @return 
	 */
	JavaSource getSource(FelContext ctx, FelNode node);
	
	void addOpti(Optimizer opti);
	
	
}
