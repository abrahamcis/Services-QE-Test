package com.at.model;

import lombok.Data;

import java.util.List;

@Data
public class PokeInfo {

    private Integer base_experience;
    private String id;
    private String name;
    private String order;
    private List<Ability> abilities;
}
