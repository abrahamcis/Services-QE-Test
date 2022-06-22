package com.at.model;

public class WorkExperience {
	private String current;
	private String description;
	private String company;
	private String from;
	private String to;
	private String title;

	public WorkExperience(String current, String description, String company, String from, String to, String title) {
		this.current = current;
		this.description = description;
		this.company = company;
		this.from = from;
		this.to = to;
		this.title = title;
	}

	public String getCurrent() {
		return current;
	}

	public String getDescription() {
		return description;
	}

	public String getCompany() {
		return company;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getTitle() {
		return title;
	}
}
