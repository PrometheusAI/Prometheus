package com.qlp.functions.predef;

import java.util.Map;

import com.qlp.QueryResponse;
import com.qlp.functions.Function;

/**
 * Finds the remainder when one number is divided by another
 * 
 * @author Tyler Senter
 * @version 1.0
 * @since 1.0
 */
public class Modulation extends Function<Number> {

	public String getName() {
		return "mod";
	}

	public QueryResponse<Number> compute(Map<String, Object> params) {
		return new QueryResponse<>((double) params.get("param1") % (double) params.get("param2"));
	}

	public int getParameterCount() {
		return 2;
	}

	public String toString() {
		return "mod(param1,param2)";
	}

	public String getKeyword() {
		return "remainder";
	}

}