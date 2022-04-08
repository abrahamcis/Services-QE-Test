package com.at.models;

import java.util.Objects;

public class SocialMedia {
    private String facebook;
    private String instagram;
    private String linkedin;
    private String pinterest;
    private String snapchat;
    private String twitter;

    public SocialMedia(String facebook, String instagram, String linkedin, String pinterest, String snapchat, String twitter) {
        this.facebook = facebook;
        this.instagram = instagram;
        this.linkedin = linkedin;
        this.pinterest = pinterest;
        this.snapchat = snapchat;
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getPinterest() {
        return pinterest;
    }

    public void setPinterest(String pinterest) {
        this.pinterest = pinterest;
    }

    public String getSnapchat() {
        return snapchat;
    }

    public void setSnapchat(String snapchat) {
        this.snapchat = snapchat;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    @Override
    public String toString() {
        return "SocialMedia{" +
                "facebook='" + facebook + '\'' +
                ", instagram='" + instagram + '\'' +
                ", linkedin='" + linkedin + '\'' +
                ", pinterest='" + pinterest + '\'' +
                ", snapchat='" + snapchat + '\'' +
                ", twitter='" + twitter + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SocialMedia)) return false;
        SocialMedia that = (SocialMedia) o;
        return Objects.equals(facebook, that.facebook) && Objects.equals(instagram, that.instagram) && Objects.equals(linkedin, that.linkedin) && Objects.equals(pinterest, that.pinterest) && Objects.equals(snapchat, that.snapchat) && Objects.equals(twitter, that.twitter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facebook, instagram, linkedin, pinterest, snapchat, twitter);
    }
}
