package com.at.model;

public class Challenge {
	private String date;
	private String name;
	private String description;
	private String url;

	public Challenge(String date, String name, String description, String url) {
		this.date = date;
		this.name = name;
		this.description = description;
		this.url = url;
	}

	public String getDate() {
		return date;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getUrl() {
		return url;
	}
}
