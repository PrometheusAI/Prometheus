package com.qlp.functions.predef;

import java.util.Map;

import com.qlp.QueryResponse;
import com.qlp.functions.Function;

public class Factorial extends Function<Number> {

	public String getName() {
		return "fact";
	}

	public QueryResponse<Number> compute(Map<String, Object> params) {
		double iterations = (double) params.get("param1");
		long result = 1;
		for (int i = 1; i <= iterations; i++)
			result *= i;
		return new QueryResponse<>(result);
	}

	public int getParameterCount() {
		return 1;
	}

	public String toString() {
		return "fact(param1)";
	}
	
	public String getKeyword() {
		return "factorial";
	}
	
}