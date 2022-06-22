package com.at.model;

public class Skill {
	private String percentage;
	private String name;

	public Skill(String percentage, String name) {
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
