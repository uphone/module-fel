package com.rino.fel.compile;

import com.rino.fel.compile.SourceBuilder;
import com.rino.fel.compile.VarBuffer;
import com.rino.fel.context.AbstractContext;
import com.rino.fel.context.FelContext;
import com.rino.fel.interpreter.Interpreter;
import com.rino.fel.parser.FelNode;

public class InterpreterSourceBuilder implements SourceBuilder {
	
	
	
	
	private static final SourceBuilder instance;
		
	public static SourceBuilder getInstance() {
		return instance;
	}

	static{
		instance = new InterpreterSourceBuilder();
	}
	
	
	
	@Override
	public Class<?> returnType(FelContext ctx, FelNode node) {
			return  AbstractContext.getVarType(node.getInterpreter().interpret(ctx, node));
	}

	/**
	 * 用户自定义解析器生成的java代码
	 * 
	 * @param ctx
	 * @param node
	 * @return
	 */
	@Override
	public String source(FelContext ctx, FelNode node) {
		// 用户设置了解释器
//			Interpreter inte = new ProxyInterpreter(node.getInterpreter(), node);
		Interpreter inte = node.getInterpreter();
			SourceBuilder nodeBuilder = node.toMethod(ctx);
			Class<?> type =nodeBuilder.returnType(ctx, node);
			String code = "("+type.getName()+")";
			String varName = VarBuffer.push(inte,Interpreter.class);
			String nodeVarName = VarBuffer.push(node, FelNode.class);
			code += varName + ".interpret(context," + nodeVarName + ")";
			boolean isNumber = Number.class.isAssignableFrom(type);
			if(isNumber){
			code = "(" + code + ")";
			}
			return code;
	}

}
