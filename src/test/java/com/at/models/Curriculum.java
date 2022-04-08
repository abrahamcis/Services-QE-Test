package com.at.models;



import com.google.gson.*;
import com.google.gson.annotations.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Objects;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

public class Curriculum {


    private List<Challenge> challenges;
    private String city;
    private Config config;
    private String country;
    private List<Educational> education;
    private String email;
    private String firstName;
    private String job;
    private List<Languages> languages;
    private String lastName;
    private String phoneNumber;
    @SerializedName(value="resourceId", alternate={"_id"})
    private String resourceId;
    private List<Skills> skills;
    private SocialMedia socialMedia;
    private List<WorkExperience> workexperience;

    public Curriculum(){

    }
    public Curriculum(List<Challenge> challenges, String city, Config config, String country, List<Educational> education, String email, String firstName, String job, String lastName, String phoneNumber, String resourceId, List<Skills> skills, SocialMedia socialMedia, List<WorkExperience> workexperience) {
        this.challenges = challenges;
        this.city = city;
        this.config = config;
        this.country = country;
        this.education = education;
        this.email = email;
        this.firstName = firstName;
        this.job = job;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.resourceId = resourceId;
        this.skills = skills;
        this.socialMedia = socialMedia;
        this.workexperience = workexperience;
    }

    public Curriculum(List<Challenge> challenges, String city, Config config, String country, List<Educational> education, String email, String firstName, String job, List<Languages> languages, String lastName, String phoneNumber, String resourceId, List<Skills> skills, SocialMedia socialMedia, List<WorkExperience> workexperience) {
        this.challenges = challenges;
        this.city = city;
        this.config = config;
        this.country = country;
        this.education = education;
        this.email = email;
        this.firstName = firstName;
        this.job = job;
        this.languages = languages;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.resourceId = resourceId;
        this.skills = skills;
        this.socialMedia = socialMedia;
        this.workexperience = workexperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curriculum)) return false;
        Curriculum that = (Curriculum) o;
        return Objects.equals(challenges, that.challenges) && Objects.equals(city, that.city) && Objects.equals(config, that.config) && Objects.equals(country, that.country) && Objects.equals(education, that.education) && Objects.equals(email, that.email) && Objects.equals(firstName, that.firstName) && Objects.equals(job, that.job) && Objects.equals(languages, that.languages) && Objects.equals(lastName, that.lastName) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(resourceId, that.resourceId) && Objects.equals(skills, that.skills) && Objects.equals(socialMedia, that.socialMedia) && Objects.equals(workexperience, that.workexperience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(challenges, city, config, country, education, email, firstName, job, languages, lastName, phoneNumber, resourceId, skills, socialMedia, workexperience);
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "challenges=" + challenges +
                ", city='" + city + '\'' +
                ", config=" + config +
                ", country='" + country + '\'' +
                ", education=" + education +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", job='" + job + '\'' +
                ", languages=" + languages +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", skills=" + skills +
                ", socialMedia=" + socialMedia +
                ", workexperience=" + workexperience +
                '}';
    }


    public List<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Educational> getEducation() {
        return education;
    }

    public void setEducation(List<Educational> education) {
        this.education = education;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public List<Languages> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Languages> languages) {
        this.languages = languages;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    public SocialMedia getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(SocialMedia socialMedia) {
        this.socialMedia = socialMedia;
    }

    public List<WorkExperience> getWorkexperience() {
        return workexperience;
    }

    public void setWorkexperience(List<WorkExperience> workexperience) {
        this.workexperience = workexperience;
    }
}
