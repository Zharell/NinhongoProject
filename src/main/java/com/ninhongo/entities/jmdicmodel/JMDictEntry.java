package com.ninhongo.entities.jmdicmodel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JMDictEntry {
	
	private String id;
	
	@JsonProperty("kanji")
	private List<Kanjidicc> kanjiDicc;
	
	@JsonProperty("kana")
	private List<Kanadicc> kana;
	
	@JsonIgnore
	private List<String> sense;
	
	public List<Kanjidicc> getKanjiDicc() {
		return kanjiDicc;
	}
	public void setKanjiDicc(List<Kanjidicc> kanjiDicc) {
		this.kanjiDicc = kanjiDicc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Kanadicc> getKana() {
		return kana;
	}
	public void setKana(List<Kanadicc> kana) {
		this.kana = kana;
	}
	public List<String> getSense() {
		return sense;
	}
	public void setSense(List<String> sense) {
		this.sense = sense;
	}
	
}
