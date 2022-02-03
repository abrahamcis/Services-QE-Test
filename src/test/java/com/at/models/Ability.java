package com.at.models;

import lombok.Data;
import lombok.Getter;
import org.json.JSONObject;

@Data
public class Ability {
	
	private JSONObject ability;
	private boolean isHidden;
	private int slot;

	public Ability(JSONObject ability, boolean isHidden, int slot) {
		this.ability = ability;
		this.isHidden = isHidden;
		this.slot = slot;
	}
}
