package com.at.model;

public class Config {
	private String fontFamily;
	private String color;
	private String genericFamily;

	public Config(String fontFamily, String color, String genericFamily) {
		this.fontFamily = fontFamily;
		this.color = color;
		this.genericFamily = genericFamily;
	}

	public String getFontFamily() {
		return fontFamily;
	}

	public String getColor() {
		return color;
	}

	public String getGenericFamily() {
		return genericFamily;
	}
}
