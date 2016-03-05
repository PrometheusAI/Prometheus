package com.qlp.functions.predef.math;

import java.util.Map;

import com.qlp.QueryResponse;
import com.qlp.functions.Function;

/**
 * Finds the product of two numbers
 * 
 * @author Tyler Senter
 * @version 1.0
 * @since 1.0
 */
public class Multiplication extends Function<Number> {

	public String getName() {
		return "mult";
	}

	public QueryResponse<Number> compute(Map<String, Object> params) {
		return new QueryResponse<Number>((double) params.get("param1") * (double) params.get("param2"));
	}
	
	public int getParameterCount() {
		return 2;
	}
	
	public String toString() {
		return "mult(param1,param2)";
	}
	
	public String getKeyword() {
		return "times";
	}

}