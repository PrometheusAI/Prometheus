package com.qlp.functions.predef.math.trig;

import java.util.Map;

import com.qlp.QueryResponse;
import com.qlp.functions.Function;

/**
 * Finds the cosine inverse of a number (commonly denoted as cos<sup>-1</sup>)
 * 
 * @author Tyler Senter
 * @version 1.0
 * @since 1.0
 */
public class Arccosine extends Function<Number> {

	public String getName() {
		return "arccos";
	}

	public QueryResponse<Number> compute(Map<String, Object> params) {
		if (params.get("mode").toString().charAt(0) == 'r') {
			return new QueryResponse<>(Math.acos((double) params.get("param1")));
		} else if (params.get("mode").toString().charAt(0) == 'd') {
			return new QueryResponse<>(Math.toDegrees(Math.acos((double) params.get("param1"))));
		} else
			throw new IllegalArgumentException("Mode parameter must be either [r]adians or [d]egrees.");
	}
	
	public int getParameterCount() {
		return 2;
	}

	public String toString() {
		return "arccos(param1,mode)";
	}
	
	public String getKeyword() {
		return "arccosine";
	}
	
}