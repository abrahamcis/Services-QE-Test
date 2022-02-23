package com.at.models;



import java.util.List;

public class Curriculum {
    private List<Challenge> chagelles;
    private String city;
    private Config config;
    private String country;
    private List<Educational> educational;
    private String email;
    private String firtsName;
    private String job;
    private List<Languages> lenguage;
    private String lastName;
    private String phoneNumber;
    private String resourceId;
    private List<Skills> skills;
    private SocialMedia socialMedia;
    private List<WorkExperience> workexperience;

    public Curriculum(){

    }

    public Curriculum(List<Educational> education,String email,String firtsName,List<Languages> lenguage,String lastName,String phoneNumber,List<Skills> skills,String resourceId){
    this.educational=  education;
    this.email=email;
    this.firtsName= firtsName;
    this.lenguage= lenguage;
    this.lastName=lastName;
    this.phoneNumber=phoneNumber;
    this.skills= skills;
    this.resourceId=resourceId;

    }
    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city=city;
    }

    public List<Challenge> getChagelles() {
        return chagelles;
    }

    public void setChagelles(List<Challenge> chagelles) {
        this.chagelles = chagelles;
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

    public List<Educational> getEducational() {
        return educational;
    }

    public void setEducational(List<Educational> educational) {
        this.educational = educational;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirtsName() {
        return firtsName;
    }

    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public List<Languages> getLenguage() {
        return lenguage;
    }

    public void setLenguage(List<Languages> lenguage) {
        this.lenguage = lenguage;
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

    public List<WorkExperience> getWorkExperiences() {
        return workexperience;
    }

    public void setWorkExperiences(List<WorkExperience> workExperiences) {
        this.workexperience = workExperiences;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "chagelles=" + chagelles +
                ", city='" + city + '\'' +
                ", config=" + config +
                ", country='" + country + '\'' +
                ", educational=" + educational +
                ", email='" + email + '\'' +
                ", firtsName='" + firtsName + '\'' +
                ", job='" + job + '\'' +
                ", lenguage=" + lenguage +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", skills=" + skills +
                ", socialMedia=" + socialMedia +
                ", workexperience=" + workexperience +
                '}';
    }
}
