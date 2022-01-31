package com.at.models;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

@Getter
@Setter
public class Type {
	
	private JSONObject type;
	private int slot;

	public Type(JSONObject type, int slot) {
		this.type = type;
		this.slot = slot;
	}
}
