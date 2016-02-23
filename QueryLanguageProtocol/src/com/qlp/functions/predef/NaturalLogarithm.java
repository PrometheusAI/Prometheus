package com.qlp.functions.predef;

import java.util.Map;

import com.qlp.QueryResponse;
import com.qlp.functions.Function;

/**
 * Finds the logarithm (base <em>e</em>) of a number
 * 
 * @author Tyler Senter
 * @version 1.0
 * @since 1.0
 */
public class NaturalLogarithm extends Function<Number> {

	public String getName() {
		return "ln";
	}

	public QueryResponse<Number> compute(Map<String, Object> params) {
		return new QueryResponse<Number>(Math.log((double) params.get("param1")));
	}

	public int getParameterCount() {
		return 1;
	}

	public String getKeyword() {
		return "ln";
	}

	public String toString() {
		return "ln(param1)";
	}

	
	
}