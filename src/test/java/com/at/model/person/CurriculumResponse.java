package com.at.model.person;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumResponse{

	@SerializedName("lastName")
	private String lastName;

	@SerializedName("country")
	private String country;

	@SerializedName("resourceId")
	private String resourceId;

	@SerializedName("education")
	private List<EducationItem> education;

	@SerializedName("languages")
	private List<LanguagesItem> languages;

	@SerializedName("city")
	private String city;

	@SerializedName("challenges")
	private List<ChallengesItem> challenges;

	@SerializedName("socialMedia")
	private SocialMedia socialMedia;

	@SerializedName("skills")
	private List<SkillsItem> skills;

	@SerializedName("firstName")
	private String firstName;

	@SerializedName("phoneNumber")
	private String phoneNumber;

	@SerializedName("workexperience")
	private List<WorkexperienceItem> workexperience;

	@SerializedName("job")
	private String job;

	@SerializedName("config")
	private Config config;

	@SerializedName("email")
	private String email;
}