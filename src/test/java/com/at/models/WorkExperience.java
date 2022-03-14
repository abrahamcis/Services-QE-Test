package com.at.models;

import org.junit.AfterClass;

public class WorkExperience {
    private String company;
    private String current;
    private String description;
    private String from;
    private String tittle;
    private String to;

    public WorkExperience(String company, String current, String description, String from, String tittle, String to) {
        this.company = company;
        this.current = current;
        this.description = description;
        this.from = from;
        this.tittle = tittle;
        this.to = to;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
