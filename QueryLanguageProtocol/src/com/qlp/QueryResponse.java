package com.qlp;

public final class QueryResponse<T> {
	
	private final T response;
	
	public QueryResponse(T response) {
		this.response = response;
	}
	
	public T getResponse() {
		return response;
	}

}