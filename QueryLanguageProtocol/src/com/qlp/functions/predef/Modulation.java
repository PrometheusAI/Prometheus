package com.qlp.functions.predef;

import java.util.Map;

import com.qlp.QueryResponse;
import com.qlp.functions.Function;

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

}