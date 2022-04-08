package com.at.models;

import java.util.Objects;

public class Config {
    private String color;
    private String fontFamily;
    private String genericFamily;

    public Config(String color, String fontFamily, String genericFamily) {
        this.color = color;
        this.fontFamily = fontFamily;
        this.genericFamily = genericFamily;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public String getGenericFamily() {
        return genericFamily;
    }

    public void setGenericFamily(String genericFamily) {
        this.genericFamily = genericFamily;
    }

    @Override
    public String toString() {
        return "Config{" +
                "color='" + color + '\'' +
                ", fontFamily='" + fontFamily + '\'' +
                ", genericFamily='" + genericFamily + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Config)) return false;
        Config config = (Config) o;
        return Objects.equals(color, config.color) && Objects.equals(fontFamily, config.fontFamily) && Objects.equals(genericFamily, config.genericFamily);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, fontFamily, genericFamily);
    }
}
