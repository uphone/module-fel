package com.rino.fel.function.operator;

import java.util.List;

import com.rino.fel.context.FelContext;
import com.rino.fel.parser.FelNode;

public class Or extends And {
	
	/** 
	 * 求逻辑或(||)
	 * @see And#logic(FelContext, java.util.List)
	 */
	Boolean logic(FelContext context, List<FelNode> children) {
		Boolean leftValue = toBoolean(context, children.get(0));
		if (leftValue.booleanValue()) {
			return leftValue;
		}
		return toBoolean(context, children.get(1));
	}
	
	@Override
	public String getName() {
		return "||";
	}

}
