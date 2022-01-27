package com.at.models;

import org.json.JSONArray;
import org.json.JSONObject;

import com.at.utils.ApiTools;

public class PokemonInfo {
	//Attributes
	String id;
	String name;
	int base_experience;
	int height;
	boolean is_default;
	int weight;
	Ability[] abilities;
	Type[] types;
	
	
	//Constructor
	public PokemonInfo(String id, String name, int base_experience, int height, boolean is_default, int weight, Ability[] abilities, Type[] types) {
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
