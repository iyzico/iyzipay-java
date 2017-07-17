package com.iyzipay.functional.builder;

import com.iyzipay.model.Buyer;

public final class BuyerBuilder {

    private String id = "BY789";
    private String name = "John";
    private String surname = "Doe";
    private String identityNumber = "74300864791";
    private String email = "email@email.com";
    private String gsmNumber = "+905350000000";
    private String registrationDate = "2013-04-21 15:12:09";
    private String lastLoginDate = "2015-10-05 12:43:35";
    private String registrationAddress = "Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1";
    private String city = "Istanbul";
    private String country = "Turkey";
    private String zipCode = "34732";
    private String ip = "85.34.78.112";

    private BuyerBuilder() {
    }

    public static BuyerBuilder create() {
        return new BuyerBuilder();
    }

    public BuyerBuilder id(String id) {
        this.id = id;
        return this;
    }

    public BuyerBuilder name(String name) {
        this.name = name;
        return this;
    }

    public BuyerBuilder surname(String surname) {
        this.surname = surname;
        return this;
    }

    public BuyerBuilder identityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
        return this;
    }

    public BuyerBuilder email(String email) {
        this.email = email;
        return this;
    }

    public BuyerBuilder gsmNumber(String gsmNumber) {
        this.gsmNumber = gsmNumber;
        return this;
    }

    public BuyerBuilder registrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public BuyerBuilder lastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
        return this;
    }

    public BuyerBuilder registrationAddress(String registrationAddress) {
        this.registrationAddress = registrationAddress;
        return this;
    }

    public BuyerBuilder city(String city) {
        this.city = city;
        return this;
    }

    public BuyerBuilder country(String country) {
        this.country = country;
        return this;
    }

    public BuyerBuilder zipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public BuyerBuilder ip(String ip) {
        this.ip = ip;
        return this;
    }

    public Buyer build() {
        Buyer buyer = new Buyer();
        buyer.setId(id);
        buyer.setName(name);
        buyer.setSurname(surname);
        buyer.setIdentityNumber(identityNumber);
        buyer.setEmail(email);
        buyer.setGsmNumber(gsmNumber);
        buyer.setRegistrationDate(registrationDate);
        buyer.setLastLoginDate(lastLoginDate);
        buyer.setRegistrationAddress(registrationAddress);
        buyer.setCity(city);
        buyer.setCountry(country);
        buyer.setZipCode(zipCode);
        buyer.setIp(ip);
        return buyer;
    }
}
