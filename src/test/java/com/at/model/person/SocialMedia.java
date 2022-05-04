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
public class SocialMedia{

	@SerializedName("snapchat")
	private Object snapchat;

	@SerializedName("twitter")
	private Object twitter;

	@SerializedName("facebook")
	private String facebook;

	@SerializedName("pinterest")
	private Object pinterest;

	@SerializedName("instagram")
	private String instagram;

	@SerializedName("linkedin")
	private String linkedin;
}