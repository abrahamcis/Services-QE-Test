package com.at.models;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

@Getter
@Setter
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
