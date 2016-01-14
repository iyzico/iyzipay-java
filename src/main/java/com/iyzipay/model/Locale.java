package com.iyzipay.model;

public enum Locale {
    EN("en"),
    TR("tr");

    private final String value;

    Locale(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
