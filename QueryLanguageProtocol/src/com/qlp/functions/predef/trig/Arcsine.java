package com.qlp.functions.predef.trig;

import java.util.Map;

import com.qlp.QueryResponse;
import com.qlp.functions.Function;

/**
 * Finds the sine inverse of a number (commonly denoted as sin<sup>-1</sup>)
 * 
 * @author Tyler Senter
 * @version 1.0
 * @since 1.0
 */
public class Arcsine extends Function<Number> {

	public String getName() {
		return "arcsin";
	}

	public QueryResponse<Number> compute(Map<String, Object> params) {
		if (params.get("mode").toString().charAt(0) == 'r') {
			return new QueryResponse<>(Math.asin((double) params.get("param1")));
		} else if (params.get("mode").toString().charAt(0) == 'd') {
			return new QueryResponse<>(Math.toDegrees(Math.asin((double) params.get("param1"))));
		} else
			throw new IllegalArgumentException("Mode parameter must be either [r]adians or [d]egrees.");
	}

	public int getParameterCount() {
		return 2;
	}
	
	public String toString() {
		return "arcsin(param1,mode)";
	}
	
	public String getKeyword() {
		return "arcsine";
	}

}