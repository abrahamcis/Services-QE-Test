package com.at.models;

import org.junit.AfterClass;

import java.util.Objects;

public class WorkExperience {
    private String company;
    private String current;
    private String description;
    private String from;
    private String title;
    private String to;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkExperience)) return false;
        WorkExperience that = (WorkExperience) o;
        return Objects.equals(company, that.company) && Objects.equals(current, that.current) && Objects.equals(description, that.description) && Objects.equals(from, that.from) && Objects.equals(title, that.title) && Objects.equals(to, that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, current, description, from, title, to);
    }

    @Override
    public String toString() {
        return "WorkExperience{" +
                "company='" + company + '\'' +
                ", current='" + current + '\'' +
                ", description='" + description + '\'' +
                ", from='" + from + '\'' +
                ", title='" + title + '\'' +
                ", to='" + to + '\'' +
                '}';
    }

    public WorkExperience(String company, String current, String description, String from, String title, String to) {
        this.company = company;
        this.current = current;
        this.description = description;
        this.from = from;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
