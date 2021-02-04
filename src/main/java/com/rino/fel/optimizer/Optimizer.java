package com.rino.fel.optimizer;

import com.rino.fel.context.FelContext;
import com.rino.fel.parser.FelNode;

/**
 * 优化器
 * @author yuqingsong
 *
 */
public interface Optimizer  {
	
	
	FelNode call(FelContext ctx, FelNode node);
}
