package com.at.model;

import lombok.Data;

@Data
public class Ability {
    private AbilityInfo ability;
    private boolean is_hidden;
    private Integer slot;

}
