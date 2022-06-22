package com.at.model;

public class SocialMedia {
	private String snapchat;
	private String twitter;
	private String facebook;
	private String pinterest;
	private String instagram;
	private String linkedin;

	public SocialMedia(String snapchat, String twitter, String facebook, String pinterest, String instagram, String linkedin) {
		this.snapchat = snapchat;
		this.twitter = twitter;
		this.facebook = facebook;
		this.pinterest = pinterest;
		this.instagram = instagram;
		this.linkedin = linkedin;
	}

	public String getSnapchat() {
		return snapchat;
	}

	public String getTwitter() {
		return twitter;
	}

	public String getFacebook() {
		return facebook;
	}

	public String getPinterest() {
		return pinterest;
	}

	public String getInstagram() {
		return instagram;
	}

	public String getLinkedin() {
		return linkedin;
	}
}
