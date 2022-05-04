package com.at.model.person;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Config{

	@SerializedName("fontFamily")
	private String fontFamily;

	@SerializedName("color")
	private String color;

	@SerializedName("genericFamily")
	private String genericFamily;
}