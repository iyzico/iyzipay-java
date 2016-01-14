package com.iyzipay.model;

import com.iyzipay.ToStringRequestBuilder;

public class Buyer {

    private String id;
    private String name;
    private String surname;
    private String identityNumber;
    private String email;
    private String gsmNumber;
    private String registrationDate;
    private String lastLoginDate;
    private String registrationAddress;
    private String city;
    private String country;
    private String zipCode;
    private String ip;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getRegistrationAddress() {
        return registrationAddress;
    }

    public void setRegistrationAddress(String registrationAddress) {
        this.registrationAddress = registrationAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("surname", surname)
                .append("identityNumber", identityNumber)
                .append("email", email)
                .append("gsmNumber", gsmNumber)
                .append("registrationDate", registrationDate)
                .append("lastLoginDate", lastLoginDate)
                .append("registrationAddress", registrationAddress)
                .append("city", city)
                .append("country", country)
                .append("zipCode", zipCode)
                .append("ip", ip)
                .toString();
    }
}
