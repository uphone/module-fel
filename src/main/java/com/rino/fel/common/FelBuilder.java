package com.rino.fel.common;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.rino.fel.function.FunMgr;
import com.rino.fel.function.operator.big.BigAdd;
import com.rino.fel.function.operator.big.BigDiv;
import com.rino.fel.function.operator.big.BigGreaterThan;
import com.rino.fel.function.operator.big.BigGreaterThanEqual;
import com.rino.fel.function.operator.big.BigLessThan;
import com.rino.fel.function.operator.big.BigLessThanEqual;
import com.rino.fel.function.operator.big.BigMod;
import com.rino.fel.function.operator.big.BigMul;
import com.rino.fel.function.operator.big.BigSub;
import com.rino.fel.security.RegexSecurityMgr;
import com.rino.fel.security.SecurityMgr;
import com.rino.fel.FelEngine;
import com.rino.fel.FelEngineImpl;
import com.rino.fel.parser.AntlrParser;
import com.rino.fel.parser.NodeAdaptor;

public class FelBuilder {

	/**
	 * 构建安全管理器
	 * @return
	 */
	public static SecurityMgr newSecurityMgr() {
		Set<String> disables = new HashSet<String>();
		disables.add(System.class.getCanonicalName() + ".*");
		disables.add(Runtime.class.getCanonicalName() + ".*");
		disables.add(Process.class.getCanonicalName() + ".*");
		disables.add(File.class.getCanonicalName() + ".*");
		disables.add("java.net.*");
		disables.add("com.rino.fel.compile.*");
		disables.add("com.rino.fel.security.*");
		return new RegexSecurityMgr(null, disables);
	}

	public static void main(String[] args) {
		System.out.println(System.class.getCanonicalName());
		System.out.println(Long.toBinaryString(0xFFFFFFFFl));
		System.out.println(Long.toBinaryString(Long.MAX_VALUE).length());
		System.out.println(Long.MAX_VALUE);
	}

	public static FelEngine bigNumberEngine() {
		return bigNumberEngine(100);
	}

	public static FelEngine engine() {
		return new FelEngineImpl();
	}

	public static FelEngine bigNumberEngine(int setPrecision) {
		FelEngine engine = new FelEngineImpl();
		FunMgr funMgr = engine.getFunMgr();
		engine.setParser(new AntlrParser(engine, new NodeAdaptor() {
			@Override
			protected Number newFloatNumber(String text) {
				char lastChar = text.charAt(text.length() - 1);
				if (lastChar == 'l' || lastChar == 'L' || lastChar == 'd' || lastChar == 'D' || lastChar == 'f'
						|| lastChar == 'F') {
					text = text.substring(0, text.length() - 1);
				}
				return new BigDecimal(text);
			}
		}));
		funMgr.add(new BigAdd());
		funMgr.add(new BigSub());
		funMgr.add(new BigMul());
		funMgr.add(new BigDiv(setPrecision));
		funMgr.add(new BigMod());
		funMgr.add(new BigGreaterThan());
		funMgr.add(new BigGreaterThanEqual());
		funMgr.add(new BigLessThan());
		funMgr.add(new BigLessThanEqual());
		return engine;
	}

}
