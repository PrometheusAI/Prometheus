package com.qlp.functions.predef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.qlp.QueryResponse;
import com.qlp.functions.Function;

public class Factors extends Function<Integer[]> {

	public String getName() {
		return "factor";
	}

	public QueryResponse<Integer[]> compute(Map<String, Object> params) {
		List<Integer> factors = new ArrayList<>();
		factors.add(1);
		int num = (int) params.get("param1");

		for (int i = 1; i < num; i++) {
			if (num % i == 0)
				factors.add(i);
		}

		Integer[] arr = factors.toArray(new Integer[factors.size()]);
		Arrays.sort(arr);

		return new QueryResponse<>(arr);
	}

	public int getParameterCount() {
		return 1;
	}

	public String toString() {
		return "factor(param1)";
	}

	public String getKeyword() {
		return "factors";
	}

}