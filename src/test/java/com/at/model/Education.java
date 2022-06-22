package com.at.model;

public class Education {
	private String career;
	private String degree;
	private String name;
	private String from;
	private String to;
	private String forever;

	public Education(String career, String degree, String name, String from, String to, String forever) {
		this.career = career;
		this.degree = degree;
		this.name = name;
		this.from = from;
		this.to = to;
		this.forever = forever;
	}

	public String getCareer() {
		return career;
	}

	public String getDegree() {
		return degree;
	}

	public String getName() {
		return name;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getForever() {
		return forever;
	}
}
