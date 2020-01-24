package com.iyzipay.request.subscription;

import com.iyzipay.Request;
import com.iyzipay.model.SubscriptionAddress;

public class UpdateSubscriptionCustomerRequest extends Request {

    private String name;
    private String surname;
    private String identityNumber;
    private String email;
    private String gsmNumber;
    private SubscriptionAddress billingAddress;
    private SubscriptionAddress shippingAddress;

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

    public SubscriptionAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(SubscriptionAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public SubscriptionAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(SubscriptionAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
