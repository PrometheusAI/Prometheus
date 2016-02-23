package com.qlp.functions.predef;

import java.util.Map;

import com.qlp.QueryResponse;
import com.qlp.functions.Function;

/**
 * Finds the logarithm (base one number) of a number
 * 
 * @author Tyler Senter
 * @version 1.0
 * @since 1.0
 */
public class Logarithm extends Function<Number> {

	public String getName() {
		return "log";
	}

	public QueryResponse<Number> compute(Map<String, Object> params) {
		return new QueryResponse<Number>(
				Math.log10((double) params.get("param1")) / Math.log10((double) params.get("base")));
	}

	public int getParameterCount() {
		return 2;
	}

	public String getKeyword() {
		return "log";
	}

	public String toString() {
		return "log(base,param1)";
	}

}