package com.at.model;

public class Language {
	private String percentage;
	private String name;

	public Language(String percentage, String name) {
		this.percentage = percentage;
		this.name = name;
	}

	public String getPercentage() {
		return percentage;
	}

	public String getName() {
		return name;
	}
}
