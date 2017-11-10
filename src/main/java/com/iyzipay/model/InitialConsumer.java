package com.iyzipay.model;

import com.iyzipay.ToStringRequestBuilder;

import java.util.List;

public class InitialConsumer {

    private String name;
    private String surname;
    private String email;
    private String gsmNumber;
    private List<IyziupAddress> addressList;

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

    public List<IyziupAddress> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<IyziupAddress> addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return new ToStringRequestBuilder(this)
                .appendSuper(super.toString())
                .append("name", name)
                .append("surname", surname)
                .append("email", email)
                .append("gsmNumber", gsmNumber)
                .append("addressList", addressList)
                .toString();
    }
}