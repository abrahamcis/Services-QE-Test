package com.at.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PokemonInfo {
	//Attributes
	private int id;
	private String name;
	private int base_experience;
	private int height;
	private boolean is_default;
	private int weight;
	private Ability[] abilities;
	private Type[] types;
	
}
