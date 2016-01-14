package com.iyzipay.model;

import com.iyzipay.ToStringRequestBuilder;

public class Address {

    private String address;
    private String zipCode;
    private String contactName;
    private String city;
    private String country;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
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

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .append("address", address)
                .append("zipCode", zipCode)
                .append("contactName", contactName)
                .append("city", city)
                .append("country", country)
                .toString();
    }
}
