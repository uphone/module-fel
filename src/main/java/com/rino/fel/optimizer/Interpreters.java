package com.rino.fel.optimizer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rino.fel.context.FelContext;
import com.rino.fel.interpreter.Interpreter;
import com.rino.fel.parser.AbstFelNode;
import com.rino.fel.parser.FelNode;


/**
 * 设置节点的解释器
 * @author yuqingsong
 *
 */
public class Interpreters implements Optimizer {

	private Map<String, Interpreter> inteMap;
	{
		inteMap = new HashMap<String, Interpreter>();
	}
	public FelNode call(FelContext ctx, FelNode node) {
			List<FelNode> nodes = AbstFelNode.getNodes(node);
			for (FelNode n : nodes) {
				String text = n.getText();
				Interpreter inte = inteMap.get(text);
				if(inte!=null){
					n.setInterpreter(inte);
				}
			}
			return node;
	}
	
	public void add(String name,Interpreter inter){
		inteMap.put(name, inter);
	}
	
	public static void main(String[] args) {
	}

}
