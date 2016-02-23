package com.qlp.functions.predef.trig;

import java.util.Map;

import com.qlp.QueryResponse;
import com.qlp.functions.Function;

/**
 * Finds the cosine of a number (commonly denoted as cos)
 * 
 * @author Tyler Senter
 * @version 1.0
 * @since 1.0
 */
public class Cosine extends Function<Number> {
	
	public String getName() {
		return "cos";
	}
	
	public QueryResponse<Number> compute(Map<String, Object> params) {
		if (params.get("mode").toString().charAt(0) == 'd')
			return new QueryResponse<>(Math.cos(Math.toRadians((double) params.get("param1"))));
		else if (params.get("mode").toString().charAt(0) == 'r')
			return new QueryResponse<>(Math.sin((double) params.get("param1")));
		else
			throw new IllegalArgumentException("Mode parameter must be in either [r]adians or [d]egrees.");
	}
	
	public int getParameterCount() {
		return 2;
	}
	
	public String toString() {
		return "cos(param1,mode)";
	}
	
	public String getKeyword() {
		return "cosine";
	}

}