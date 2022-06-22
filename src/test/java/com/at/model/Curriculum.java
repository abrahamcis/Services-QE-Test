package com.at.model;

import java.util.List;

public class Curriculum {
	private String resourceId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String city;
	private String job;
	private String country;
	private SocialMedia socialMedia;
	private Config config;
	private List<Education> education;
	private List<WorkExperience> workexperience;
	private List<Language> languages;
	private List<Challenge> challenges;
	private List<Skill> skills;

	public Curriculum(String resourceId, String firstName, String lastName, String email, String phoneNumber, String city,
					  String job, String country, SocialMedia socialMedia, Config config, List<Education> education,
					  List<WorkExperience> workexperience, List<Language> languages, List<Challenge> challenges,
					  List<Skill> skills) {
		this.resourceId = resourceId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.job = job;
		this.country = country;
		this.socialMedia = socialMedia;
		this.config = config;
		this.education = education;
		this.workexperience = workexperience;
		this.languages = languages;
		this.challenges = challenges;
		this.skills = skills;
	}

	public Curriculum() {}

	public String getResourceId() {
		return resourceId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public String getJob() {
		return job;
	}

	public String getCountry() {
		return country;
	}

	public SocialMedia getSocialMedia() {
		return socialMedia;
	}

	public Config getConfig() {
		return config;
	}

	public List<Education> getEducation() {
		return education;
	}

	public List<WorkExperience> getWorkexperience() {
		return workexperience;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public List<Challenge> getChallenges() {
		return challenges;
	}

	public List<Skill> getSkills() {
		return skills;
	}
}