package com.at.models;

import java.util.Objects;

public class Educational {
    private String career;
    private String degree;
    private String forever;
    private String from;
    private String name;
    private String to;

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getForever() {
        return forever;
    }

    public void setForever(String forever) {
        this.forever = forever;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Educational{" +
                "career='" + career + '\'' +
                ", degree='" + degree + '\'' +
                ", forever='" + forever + '\'' +
                ", from='" + from + '\'' +
                ", name='" + name + '\'' +
                ", to='" + to + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Educational)) return false;
        Educational that = (Educational) o;
        return Objects.equals(career, that.career) && Objects.equals(degree, that.degree) && Objects.equals(forever, that.forever) && Objects.equals(from, that.from) && Objects.equals(name, that.name) && Objects.equals(to, that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(career, degree, forever, from, name, to);
    }
}
