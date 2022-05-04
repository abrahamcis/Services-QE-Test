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
public class WorkexperienceItem{

	@SerializedName("current")
	private String current;

	@SerializedName("description")
	private String description;

	@SerializedName("company")
	private String company;

	@SerializedName("from")
	private String from;

	@SerializedName("to")
	private Object to;

	@SerializedName("title")
	private String title;
}