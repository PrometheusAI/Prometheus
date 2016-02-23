package com.qlp.functions.predef;

import java.util.Map;

import com.qlp.QueryResponse;
import com.qlp.functions.Function;

/**
 * Determines whether or not a variable is defined
 * 
 * @author Tyler Senter
 * @version 1.0
 * @since 1.0
 */
public class VariableDefined extends Function<Number> {

	public String getName() {
		return "isdef";
	}

	public QueryResponse<Number> compute(Map<String, Object> params) {
		return new QueryResponse<Number>(
				((VariableDefinition) Function.getFunction("vardef")).vars.containsKey(params.get("name")) ? 1 : 0);
	}

	public int getParameterCount() {
		return 1;
	}

	public String getKeyword() {
		return "";
	}

	public String toString() {
		return "isdef(name)";
	}

}