package com.qlp.functions.predef;

import java.util.HashMap;
import java.util.Map;

import com.qlp.QueryResponse;
import com.qlp.functions.Function;

/**
 * Defines a variable with a given value
 * 
 * @author Tyler Senter
 * @version 1.0
 * @since 1.0
 */
public class VariableDefinition extends Function<Object> {

	protected final Map<String, Object> vars;

	public VariableDefinition() {
		vars = new HashMap<>();
	}

	public String getName() {
		return "vardef";
	}

	public QueryResponse<Object> compute(Map<String, Object> params) {
		Object old;
		if (vars.containsKey(params.get("name")))
			old = vars.get(params.get("name"));
		else
			old = params.get("value");

		vars.put((String) params.get("name"), params.get("value"));

		return new QueryResponse<>(old);
	}

	public int getParameterCount() {
		return 2;
	}

	public String toString() {
		return "vardef(name,value)";
	}

	public String getKeyword() {
		return "";
	}

}