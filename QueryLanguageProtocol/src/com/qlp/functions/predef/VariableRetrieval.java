package com.qlp.functions.predef;

import java.util.Map;

import com.qlp.QueryResponse;
import com.qlp.functions.Function;

public class VariableRetrieval extends Function<Object> {

	public String getName() {
		return "var";
	}

	public QueryResponse<Object> compute(Map<String, Object> params) {
		return new QueryResponse<>(((VariableDefinition) Function.getFunction("vardef")).vars.get(params.get("name")));
	}

	public int getParameterCount() {
		return 1;
	}

	public String toString() {
		return "var(name)";
	}

	public String getKeyword() {
		return "";
	}

}