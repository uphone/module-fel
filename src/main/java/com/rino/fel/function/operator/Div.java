package com.rino.fel.function.operator;

import com.rino.fel.common.NumberUtil;

public class Div extends Mul {

	@Override
	Object calc(double l, double r) {
		return NumberUtil.parseNumber(l / r);
	}
	
	@Override
	public String getName() {
		return "/";
	}
}
