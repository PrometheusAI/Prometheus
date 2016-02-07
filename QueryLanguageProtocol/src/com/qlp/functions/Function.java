package com.qlp.functions;

import java.util.HashMap;
import java.util.Map;

import com.qlp.QueryResponse;

public abstract class Function<T> {

	public Function() {
	}

	private static final Map<String, Function<?>> functions = new HashMap<>();

	public abstract String getName();

	public abstract QueryResponse<T> compute(Map<String, Object> params);

	public abstract int getParameterCount();

	public abstract String toString();

	public String[] getParameterNames() {
		StringBuilder raw = new StringBuilder();
		boolean toNames = false;

		for (char c : toString().toCharArray()) {
			if (toNames) {
				if (c == ')') {
					toNames = false;
					continue;
				}
				if (c != ' ')
					raw.append(c);
			} else if (c == '(')
				toNames = true;
		}

		return raw.toString().split(",");
	}

	public static Function<?> getFunction(String function) {
		return functions.get(function);
	}

	public static void registerFunction(Class<?> newFunction) {
		if (newFunction == null)
			throw new IllegalArgumentException("Registered class cannot be null!");
		try {
			if (Function.class.isAssignableFrom(newFunction)) {
				Function<?> func = (Function<?>) newFunction.getConstructors()[0].newInstance();
				functions.put(func.getName(), func);
			} else
				throw new IllegalArgumentException("Must register a child of com.qlp.functions.Function");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}