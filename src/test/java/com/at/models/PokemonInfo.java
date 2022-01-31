package com.at.models;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONObject;

import com.at.utils.ApiTools;
@Getter
@Setter
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

	
	//Constructor
    public PokemonInfo(int id, String name, int base_experience, int height, boolean is_default, int weight, Ability[] abilities, Type[] types) {
		this.id = id;
		this.name = name;
		this.base_experience = base_experience;
		this.height = height;
		this.is_default = is_default;
		this.weight = weight;
		this.abilities = abilities;
		this.types = types;
	}

    public static void main(String[] args) {


	}
	
}
