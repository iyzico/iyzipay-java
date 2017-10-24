package com.iyzipay.model;

import com.iyzipay.ToStringRequestBuilder;

public class IyziupAddress {

    private String alias;
    private String addressLine1;
    private String addressLine2;
    private String zipCode;
    private String contactName;
    private String city;
    private String country;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
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
                .appendSuper(super.toString())
                .append("alias", alias)
                .append("addressLine1", addressLine1)
                .append("addressLine2", addressLine2)
                .append("zipCode", zipCode)
                .append("contactName", contactName)
                .append("city", city)
                .append("country", country)
                .toString();
    }
}
