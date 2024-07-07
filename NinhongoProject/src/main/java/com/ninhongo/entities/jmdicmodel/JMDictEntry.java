package com.ninhongo.entities.jmdicmodel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JMDictEntry {
	
	private String id;
	
	@JsonProperty("kanji")
	private List<Kanjidicc> kanjiDicc;
	
	@JsonProperty("kana")
	private List<Kanadicc> kanaDicc;
	
	@JsonProperty("sense")
	private List<Sensedicc> senseDicc;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Kanjidicc> getKanjiDicc() {
		return kanjiDicc;
	}

	public void setKanjiDicc(List<Kanjidicc> kanjiDicc) {
		this.kanjiDicc = kanjiDicc;
	}

	public List<Kanadicc> getKanaDicc() {
		return kanaDicc;
	}

	public void setKanaDicc(List<Kanadicc> kanaDicc) {
		this.kanaDicc = kanaDicc;
	}

	public List<Sensedicc> getSenseDicc() {
		return senseDicc;
	}

	public void setSenseDicc(List<Sensedicc> senseDicc) {
		this.senseDicc = senseDicc;
	}

}
