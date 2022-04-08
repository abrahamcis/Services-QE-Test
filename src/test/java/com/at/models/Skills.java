package com.at.models;

import java.util.Objects;

public class Skills {
    private String name;
    private String percentage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "name='" + name + '\'' +
                ", percentage='" + percentage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skills)) return false;
        Skills skills = (Skills) o;
        return Objects.equals(name, skills.name) && Objects.equals(percentage, skills.percentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, percentage);
    }
}
