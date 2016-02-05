package com.tylersenter.prometheus.grammar;

public enum PartOfSpeech {

	VERB("Verb"), 
	NOUN("Noun"), 
	ADJECTIVE("Adjective"), 
	DETERMINER("Determiner"), 
	ADVERB("Adverb"), 
	PRONOUN("Pronoun"), 
	PREPOSITION("Preposition"), 
	CONJUNCTION("Conjunction"), 
	INTERJECTION("Interjection");

	private final String name;
	
	private PartOfSpeech(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
}