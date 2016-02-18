package com.tylersenter.prometheus.interpreter;

public class Interpreter {

	private String response;
	private String oQuery;

	public Interpreter(String query) {
		/**
		 * 
		 * 		What is six cubed divided by 4?
		 *       |_____|
		 *          |
		 *        Math
		 * 		"six cubed divided by 4"
		 * 		math:six cubed divided by 4
		 * 
		 * 		what, how, where, who, when, why
		 * 
		 */
		oQuery = query;
	}

	public String getResponse() {
		return response;
	}

}