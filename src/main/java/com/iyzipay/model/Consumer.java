package com.iyzipay.model;

import com.iyzipay.ToStringRequestBuilder;

public class Consumer {

    private String name;
    private String surname;
    private String identityNumber;
    private String email;
    private String gsmNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGsmNumber() {
        return gsmNumber;
    }

    public void setGsmNumber(String gsmNumber) {
        this.gsmNumber = gsmNumber;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .append("name", name)
                .append("surname", surname)
                .append("identityNumber", identityNumber)
                .append("email", email)
                .append("gsmNumber", gsmNumber)
                .toString();
    }
}
