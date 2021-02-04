package com.rino.fel.interpreter;

import com.rino.fel.context.FelContext;
import com.rino.fel.parser.FelNode;

/**
 * 代理解释器，用于保存节点
 * @author yuqingsong
 *
 */
public class ProxyInterpreter implements Interpreter{
	
	private Interpreter inte;
	
	private FelNode node;
	public ProxyInterpreter(Interpreter inte,FelNode node){
		this.inte = inte;
		this.node = node;
	}
	public Object interpret(FelContext context, FelNode node) {
		return inte.interpret(context, this.node);
	}

}
