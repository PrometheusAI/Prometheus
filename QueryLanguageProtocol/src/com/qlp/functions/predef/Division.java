package com.qlp.functions.predef;

import java.util.Map;

import com.qlp.QueryResponse;
import com.qlp.functions.Function;

public class Division extends Function<Number> {

	@Override
	public String getName() {
		return "div";
	}

	@Override
	public QueryResponse<Number> compute(Map<String, Object> params) {
		return new QueryResponse<Number>((double) params.get(0) / (double) params.get(1));
	}

	public String toString() {
		return "div(param1, param2)";
	}
	
}