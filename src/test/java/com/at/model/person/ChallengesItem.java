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
public class ChallengesItem{

	@SerializedName("date")
	private String date;

	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private String description;

	@SerializedName("url")
	private String url;
}