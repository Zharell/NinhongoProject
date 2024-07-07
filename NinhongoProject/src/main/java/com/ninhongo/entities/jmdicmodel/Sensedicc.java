package com.ninhongo.entities.jmdicmodel;

import java.util.List;

public class Sensedicc {
	
	
	private List<List<String>> antonym;
	private List<String> appliesToKana;
	private List<String> appliesToKanji;
	private List<String> dialect;
	private List<String> field;
	private List<String> Tag;
	private List<SenseGlossdicc> gloss;
	private List<String> info;
	
	private List<SenseLanguageSourcedicc> languageSource;
	
	private List<String> misc;
	private List<String> partOfSpeech;
	private List<List<String>> related;
	
	public List<List<String>> getAntonym() {
		return antonym;
	}
	public void setAntonym(List<List<String>> antonym) {
		this.antonym = antonym;
	}
	public List<String> getAppliesToKana() {
		return appliesToKana;
	}
	public void setAppliesToKana(List<String> appliesToKana) {
		this.appliesToKana = appliesToKana;
	}
	public List<String> getAppliesToKanji() {
		return appliesToKanji;
	}
	public void setAppliesToKanji(List<String> appliesToKanji) {
		this.appliesToKanji = appliesToKanji;
	}
	public List<String> getDialect() {
		return dialect;
	}
	public void setDialect(List<String> dialect) {
		this.dialect = dialect;
	}
	public List<String> getField() {
		return field;
	}
	public void setField(List<String> field) {
		this.field = field;
	}
	public List<String> getTag() {
		return Tag;
	}
	public void setTag(List<String> tag) {
		Tag = tag;
	}
	public List<SenseGlossdicc> getGloss() {
		return gloss;
	}
	public void setGloss(List<SenseGlossdicc> gloss) {
		this.gloss = gloss;
	}
	public List<String> getInfo() {
		return info;
	}
	public void setInfo(List<String> info) {
		this.info = info;
	}
	public List<SenseLanguageSourcedicc>  getLanguageSource() {
		return languageSource;
	}
	public void setLanguageSource(List<SenseLanguageSourcedicc>  languageSource) {
		this.languageSource = languageSource;
	}
	public List<String> getMisc() {
		return misc;
	}
	public void setMisc(List<String> misc) {
		this.misc = misc;
	}
	public List<String> getPartOfSpeech() {
		return partOfSpeech;
	}
	public void setPartOfSpeech(List<String> partOfSpeech) {
		this.partOfSpeech = partOfSpeech;
	}
	public List<List<String>> getRelated() {
		return related;
	}
	public void setRelated(List<List<String>> related) {
		this.related = related;
	}
	
}
