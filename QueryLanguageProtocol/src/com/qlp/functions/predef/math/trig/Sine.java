package com.qlp.functions.predef.math.trig;

import java.util.Map;

import com.qlp.QueryResponse;
import com.qlp.functions.Function;

/**
 * Finds the sine of a number (commonly denoted as sin)
 * 
 * @author Tyler Senter
 * @version 1.0
 * @since 1.0
 */
public class Sine extends Function<Number> {

	public String getName() {
		return "sin";
	}

	public QueryResponse<Number> compute(Map<String, Object> params) {
		if (params.get("mode").toString().charAt(0) == 'd')
			return new QueryResponse<>(Math.sin(Math.toRadians((double) params.get("param1"))));
		else if (params.get("mode").toString().charAt(0) == 'r')
			return new QueryResponse<>(Math.sin((double) params.get("param1")));
		else
			throw new IllegalArgumentException("Mode parameter must be in either [r]adians or [d]egrees, not "
					+ params.get("mode").toString().indexOf(0));
	}

	public int getParameterCount() {
		return 2;
	}

	public String toString() {
		return "sin(param1,mode)";
	}
	
	public String getKeyword() {
		return "sine";
	}

}