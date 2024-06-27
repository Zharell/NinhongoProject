package com.ninhongo.entities.jmdicmodel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Kanadicc {
	
	private List<String> appliesToKanji;
	private boolean common;
	private List<String> tags;
	private String text;
	
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public List<String>getAppliesToKanji() {
		return appliesToKanji;
	}
	public void setAppliesToKanji(List<String> appliesToKanji) {
		this.appliesToKanji = appliesToKanji;
	}
	public boolean isCommon() {
		return common;
	}
	public void setCommon(boolean common) {
		this.common = common;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
