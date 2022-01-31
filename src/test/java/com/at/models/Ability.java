package com.at.models;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;

@Getter
@Setter
public class Ability {
	
	private String ability;
	private boolean isHidden;
	private int slot;

	public Ability(String ability, boolean isHidden, int slot) {
		this.ability = ability;
		this.isHidden = isHidden;
		this.slot = slot;
	}
}
