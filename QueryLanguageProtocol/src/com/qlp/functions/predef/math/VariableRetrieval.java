package com.qlp.functions.predef.math;

import java.util.Map;

import com.qlp.QueryResponse;
import com.qlp.functions.Function;

/**
 * Retrieves the value of a variable
 * 
 * @author Tyler Senter
 * @version 1.0
 * @since 1.0
 */
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