package com.qlp.functions.predef.math.trig;

import java.util.Map;

import com.qlp.QueryResponse;
import com.qlp.functions.Function;

/**
 * Finds the tangent of a number (commonly denoted as tan)
 * 
 * @author Tyler Senter
 * @version 1.0
 * @since 1.0
 */
public class Tangent extends Function<Number> {

	public String getName() {
		return "tan";
	}

	public QueryResponse<Number> compute(Map<String, Object> params) {
		if (params.get("mode").toString().charAt(0) == 'd')
			return new QueryResponse<>(Math.tan(Math.toRadians((double) params.get("param1"))));
		else if (params.get("mode").toString().charAt(0) == 'r')
			return new QueryResponse<>(Math.tan((double) params.get("param1")));
		else
			throw new IllegalArgumentException("Mode parameter must be in either [r]adians or [d]egrees.");
	}

	public int getParameterCount() {
		return 2;
	}
	
	public String toString() {
		return "tan(param1,mode)";
	}
	
	public String getKeyword() {
		return "tangent";
	}
	
}