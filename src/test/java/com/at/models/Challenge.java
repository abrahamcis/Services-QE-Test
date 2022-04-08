package com.at.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Challenge {
    private String name;
    private String date;
    private String description;
    private String url;



    @Override
    public String toString() {
        return "Challenge{" +
                "date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Challenge)) return false;
        Challenge challenge = (Challenge) o;
        return Objects.equals(date, challenge.date) && Objects.equals(description, challenge.description) && Objects.equals(name, challenge.name) && Objects.equals(url, challenge.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, description, name, url);
    }
}
