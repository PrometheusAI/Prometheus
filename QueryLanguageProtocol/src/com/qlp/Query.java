package com.qlp;

import java.util.LinkedHashMap;
import java.util.Map;

public class Query {

	private static final Map<String, QueryHandler> handlers = new LinkedHashMap<String, QueryHandler>();
	
	public static QueryResponse<String> query(String query) {
		StringBuilder str = new StringBuilder();
		for (char c : query.toCharArray())
			if (c != ':')
				str.append(c);
		
		// [handler]:[query]
		
		return handlers.get(str.toString()).query(query);
	}
	
	public static void registerQueryHandler(String identifier, QueryHandler handler) {
		if (handlers.containsKey(identifier) || identifier == null)
			throw new IllegalArgumentException("String identifier already defined for another handler!");
		if (handler == null)
			throw new IllegalArgumentException("Cannot register null handler!");
		handlers.put(identifier, handler);
	}
	
}