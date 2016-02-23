package com.qlp.functions.predef;

import java.util.LinkedHashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.qlp.QueryResponse;
import com.qlp.functions.Function;

/**
 * Raises one number to a power
 * 
 * @author Tyler Senter
 * @version 1.0
 * @since 1.0
 */
public class Powers extends Function<Number> {
	
	private final ImmutableMap<Integer, String> powers;
	
	public Powers() {
		LinkedHashMap<Integer, String> pows = new LinkedHashMap<>();

		pows.put(1, "first");
		pows.put(2, "square");
		pows.put(3, "cube");
		
		
		powers = ImmutableMap.copyOf(pows);
	}

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

	public String toString() {
		return "pow(param1,param2)";
	}

	public String getKeyword() {
		return "power";
	}
	
	public String getNameOfPower(int power) {
		if (power == 1)
			return "";
		return powers.get(power) + "d";
	}
	
	public String getNameOfRoot(int power) {
		return powers.get(power) + " root";
	}
	
}