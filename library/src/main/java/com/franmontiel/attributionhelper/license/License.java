package com.franmontiel.attributionhelper.license;

public class License {
    private String name;
    private String textUrl;

    public License(String name, String textUrl) {
        this.name = name;
        this.textUrl = textUrl;
    }

    public String getName() {
        return name;
    }

    public String getTextUrl() {
        return textUrl;
    }

    @Override
    public String toString() {
        return name;
    }
}
