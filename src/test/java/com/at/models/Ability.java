package com.at.models;

import lombok.Data;
import lombok.Getter;
import org.json.JSONObject;

@Data
public class Ability {
	
	private AbilityName ability;
	private boolean is_hidden;
	private int slot;

	public Ability(AbilityName ability, boolean is_hidden, int slot) {
		this.ability = ability;
		this.is_hidden = is_hidden;
		this.slot = slot;
	}
}
