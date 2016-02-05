package com.qlp.functions;

import java.util.HashMap;
import java.util.Map;

import com.qlp.QueryResponse;

public abstract class Function<T> {

	public Function() {}
	
	private static final Map<String, Function<?>> functions = new HashMap<>();

	public abstract String getName();

	public abstract QueryResponse<T> compute(Map<String, Object> params);
	
	public abstract String toString();

	public static Function<?> getFunction(String function) {
		return functions.get(function);
	}

	public static void registerFunction(Class<? extends Function<?>> newFunction) {
		try {
			Function<?> func = (Function<?>) newFunction.getConstructors()[0].newInstance();
			functions.put(func.getName(), func);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}