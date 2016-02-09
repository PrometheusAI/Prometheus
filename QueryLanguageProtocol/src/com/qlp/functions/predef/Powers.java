package com.qlp.functions.predef;

import java.util.Map;

import com.qlp.QueryResponse;
import com.qlp.functions.Function;

public class Powers extends Function<Number> {
	
//	private static final ImmutableMap<String, Integer> powers;
	
	public Powers() {
//		powers = (ImmutableMap<String, Integer>) ImmutableMap.builder().build();
	}

	public String getName() {
		return "pow";
	}

	public QueryResponse<Number> compute(Map<String, Object> params) {
		return new QueryResponse<>(Math.pow(Double.valueOf(params.get("param1").toString()),
				Double.valueOf(params.get("param2").toString())));
	}
	
	public int getParameterCount() {
		return 2;
	}

	public String toString() {
		return "pow(param1,param2)";
	}

	public String getKeyword() {
		return "power";
	}
	
}