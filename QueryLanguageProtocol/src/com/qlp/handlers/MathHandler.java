package com.qlp.handlers;

import java.util.LinkedHashMap;

import com.qlp.ObjectUtils;
import com.qlp.QueryHandler;
import com.qlp.QueryResponse;
import com.qlp.functions.Function;

public class MathHandler implements QueryHandler {

	public QueryResponse<String> query(String query) {
		// Interpret user input
		String function = "";
		
		/**
		 * six cubed divided by 4
		 * 
		 * div(pow(6,3),4)
		 * 
		 */
		
		return null;
	}

	public QueryResponse<?> computeFunction(String function) {
		StringBuilder str = new StringBuilder();
		char[] seq = function.toCharArray();
		String[] paramNames = null;
		Object[] paramsActual = new Object[0];
		Function<?> func = null;
		LinkedHashMap<String, Object> parameters = new LinkedHashMap<String, Object>();
		for (int i = 0; i < function.length(); i++) {
			if (Character.isLetter(seq[i]) && func == null)
				str.append(function);
			if (seq[i] == '(')
				if (func == null)
					func = Function.getFunction(str.toString());
			if (paramsActual.length != func.getParameterCount()) {
				paramsActual = new Object[func.getParameterCount()];
				paramNames = func.getParameterNames();
			}

		}

		for (int i = 0; i < paramNames.length; i++)
			parameters.put(paramNames[i], paramsActual[i]);

		return func.compute(parameters);

	}
	
	public static Number computeAllFunctions(String function) {
		double value = 0;
		while (function.contains("(")) {
			value = computeIndividualFunction(
					getFunction(function, function.lastIndexOf("("), function.indexOf(")", function.lastIndexOf("("))))
							.doubleValue();
			function = function.replace(
					getFunction(function, function.lastIndexOf("("), function.indexOf(")", function.lastIndexOf("("))),
					Double.toString(value));
		}
		return value;
	}

	static String getFunction(String function, int start, int finish) {
		char[] arr = function.toCharArray();
		for (int i = start - 1; true; i--) { // "func2(func3(),stringOfCharacters(param1,param2,...),2)"
			if (i == 0)
				return function;
			if (arr[i] == '(' || arr[i] == ',') {
				return function.substring(i + 1, finish + 1);
			}
		}
	}

	public static Number computeIndividualFunction(String function) {
		StringBuilder func = new StringBuilder(), temp = new StringBuilder();
		Function<?> aFunc = null;
		String[] paramNames = null;
		Object[] parameters = null;
		boolean toParams = false;
		int currentParam = 0;
		for (char c : function.toCharArray()) {
			if (c == '(') {
				aFunc = Function.getFunction(func.toString());
				paramNames = aFunc.getParameterNames();
				parameters = new Object[paramNames.length];
				toParams = true;
			} else if (!toParams) {
				func.append(c);
			} else if (toParams) {
				if (c == ')') {
					if (ObjectUtils.isDouble(temp.toString()))
						parameters[currentParam] = Double.parseDouble(temp.toString());
					else
						parameters[currentParam] = temp.toString();
					break;
				}
				if (c == ',') {
					if (ObjectUtils.isDouble(temp.toString()))
						parameters[currentParam] = Double.parseDouble(temp.toString());
					else
						parameters[currentParam] = temp.toString();
					temp.delete(0, temp.length());
					currentParam++;
				} else {
					temp.append(c);
				}
			}
		}

		LinkedHashMap<String, Object> params = new LinkedHashMap<>();
		for (int i = 0; i < paramNames.length; i++)
			params.put(paramNames[i], parameters[i]);

		return (Number) aFunc.compute(params).getResponse();
	}

}