package com.ninhongo.entities.jmdicmodel;

import java.util.List;

public class Kanjidicc {

	private boolean common;
	private String text;
	private List<String> tags;
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
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	
}
