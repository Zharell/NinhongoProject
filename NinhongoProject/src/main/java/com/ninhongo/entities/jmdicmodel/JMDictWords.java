package com.ninhongo.entities.jmdicmodel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JMDictWords {
	
	@JsonProperty("words")
	private List<JMDictEntry> jmDictWords;
	
	public List<JMDictEntry> getJmDictWords() {
		return jmDictWords;
	}

	public void setJmDictWords(List<JMDictEntry> jmDictWords) {
		this.jmDictWords = jmDictWords;
	}
	
	
}
