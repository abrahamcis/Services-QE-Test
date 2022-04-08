package com.at.models;

import java.util.Objects;

public class Languages {
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
        return "Languages{" +
                "name='" + name + '\'' +
                ", percentage='" + percentage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Languages)) return false;
        Languages languages = (Languages) o;
        return Objects.equals(name, languages.name) && Objects.equals(percentage, languages.percentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, percentage);
    }
}
