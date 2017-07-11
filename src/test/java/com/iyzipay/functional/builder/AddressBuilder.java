package com.iyzipay.functional.builder;

import com.iyzipay.model.Address;

public final class AddressBuilder {

    private String address = "Nidakule Göztepe, Merdivenköy Mah. Bora Sok. No:1";
    private String zipCode = "34742";
    private String contactName = "Jane Doe";
    private String city = "Istanbul";
    private String country = "Turkey";

    private AddressBuilder() {
    }

    public static AddressBuilder create() {
        return new AddressBuilder();
    }

    public AddressBuilder address(String address) {
        this.address = address;
        return this;
    }

    public AddressBuilder zipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public AddressBuilder contactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public AddressBuilder city(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder country(String country) {
        this.country = country;
        return this;
    }

    public Address build() {
        Address addressModel = new Address();
        addressModel.setAddress(address);
        addressModel.setZipCode(zipCode);
        addressModel.setContactName(contactName);
        addressModel.setCity(city);
        addressModel.setCountry(country);
        return addressModel;
    }
}
