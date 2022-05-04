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
public class SkillsItem{

	@SerializedName("percentage")
	private String percentage;

	@SerializedName("name")
	private String name;
}