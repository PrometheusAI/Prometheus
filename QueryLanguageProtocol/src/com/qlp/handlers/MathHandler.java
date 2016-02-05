package com.qlp.handlers;

import com.qlp.QueryHandler;
import com.qlp.QueryResponse;

public class MathHandler implements QueryHandler {

	public QueryResponse<String> query(String query) {
		StringBuilder queryMod = new StringBuilder(query.substring(5));

		while (queryMod.length() > 0) {
			
		}

		return new QueryResponse<>(query);
	}

}