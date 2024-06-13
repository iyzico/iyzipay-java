package com.iyzipay.model;

import com.iyzipay.IyzipayResource;

public class PayWithIyzicoInitializeResource extends IyzipayResource {
    private String token;
    private Long tokenExpireTime;
    private String payWithIyzicoPageUrl;
    private String checksum;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getTokenExpireTime() {
        return tokenExpireTime;
    }

    public void setTokenExpireTime(Long tokenExpireTime) {
        this.tokenExpireTime = tokenExpireTime;
    }

    public String getPayWithIyzicoPageUrl() {
        return payWithIyzicoPageUrl;
    }

    public void setPayWithIyzicoPageUrl(String payWithIyzicoPageUrl) {
        this.payWithIyzicoPageUrl = payWithIyzicoPageUrl;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }
}
