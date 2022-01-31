package com.at.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Type {
	
	private String type;
	private int slot;

	public Type(String type, int slot) {
		this.type = type;
		this.slot = slot;
	}
}
