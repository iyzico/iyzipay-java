package com.iyzipay.model;

import com.iyzipay.IyzipayResource;

public class IyziupFormInitializeResource extends IyzipayResource {

    private String token;
    private String content;
    private Long tokenExpireTime;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getTokenExpireTime() {
        return tokenExpireTime;
    }

    public void setTokenExpireTime(Long tokenExpireTime) {
        this.tokenExpireTime = tokenExpireTime;
    }
}
