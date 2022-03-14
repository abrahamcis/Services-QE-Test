package com.at.models;

public class Challenge {
    private String date;
    private String descrption;
    private String name;
    private String url;

    public Challenge(String date, String descrption, String name, String url) {
        this.date = date;
        this.descrption = descrption;
        this.name = name;
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
