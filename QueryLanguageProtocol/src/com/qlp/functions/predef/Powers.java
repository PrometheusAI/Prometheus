package com.qlp.functions.predef;

import java.util.Map;

import com.qlp.QueryResponse;
import com.qlp.functions.Function;

public class Powers extends Function<Number> {

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

	@Override
	public String toString() {
		return "pow(param1,param2)";
	}

}