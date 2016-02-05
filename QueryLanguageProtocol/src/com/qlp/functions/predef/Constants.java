package com.qlp.functions.predef;

import java.util.HashMap;
import java.util.Map;

import com.qlp.QueryResponse;
import com.qlp.functions.Function;

public class Constants extends Function<Number> {
	
	private static final Map<String, Double> constants = new HashMap<String, Double>();

	public Constants() {}
	
	public String getName() {
		return "const";
	}

	public QueryResponse<Number> compute(Map<String, Object> params) {
		return new QueryResponse<Number>(constants.get(((String) params.get(0)).toLowerCase()));
	}
	
	public String toString() {
		return "const(param1)";
	}
	
	static {
		// pi
		constants.put("pi", 3.14159265358979);
		// e
		constants.put("e", 2.71828182845905);
		// golden ratio
		constants.put("gdra", 1.61803398874989);
	}

}