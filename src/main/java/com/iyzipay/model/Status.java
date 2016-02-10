package com.iyzipay.model;

public enum Status {
    SUCCESS("success"),
    FAILURE("failure");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
