package com.iyzipay.model;

import com.iyzipay.IyzipayResource;

public class CheckoutFormInitializeResource extends IyzipayResource {

    private String token;
    private String checkoutFormContent;
    private Long tokenExpireTime;
    private String paymentPageUrl;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCheckoutFormContent() {
        return checkoutFormContent;
    }

    public void setCheckoutFormContent(String checkoutFormContent) {
        this.checkoutFormContent = checkoutFormContent;
    }

    public Long getTokenExpireTime() {
        return tokenExpireTime;
    }

    public void setTokenExpireTime(Long tokenExpireTime) {
        this.tokenExpireTime = tokenExpireTime;
    }

    public String getPaymentPageUrl() {
        return paymentPageUrl;
    }

    public void setPaymentPageUrl(String paymentPageUrl) {
        this.paymentPageUrl = paymentPageUrl;
    }
}
