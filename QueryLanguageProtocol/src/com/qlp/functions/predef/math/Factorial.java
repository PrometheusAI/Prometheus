package com.qlp.functions.predef.math;

import java.util.Map;

import com.qlp.QueryResponse;
import com.qlp.functions.Function;

/**
 * Determines the factorial of a number (commonly denoted as n!)
 * 
 * @author Tyler Senter
 * @version 1.0
 * @since 1.0
 */
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