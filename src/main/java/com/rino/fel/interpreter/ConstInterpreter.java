package com.rino.fel.interpreter;

import com.rino.fel.context.FelContext;
import com.rino.fel.parser.FelNode;

public class ConstInterpreter implements Interpreter {

	private Object value;

	public ConstInterpreter(FelContext context, FelNode node) {
		this.value = node.eval(context);
	}

	public Object interpret(FelContext context, FelNode node) {
		return value;
	}

}
