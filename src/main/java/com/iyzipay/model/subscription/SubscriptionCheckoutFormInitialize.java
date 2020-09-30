package com.iyzipay.model.subscription;

import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.subscription.InitializeSubscriptionCheckoutFormRequest;

public class SubscriptionCheckoutFormInitialize extends IyzipayResource {

    private String token;
    private String checkoutFormContent;
    private Long tokenExpireTime;

    public static SubscriptionCheckoutFormInitialize create(InitializeSubscriptionCheckoutFormRequest request, Options options) {
        String uri = options.getBaseUrl() + "/v2/subscription/checkoutform/initialize";
        return HttpClient.create().post(uri,
                getHttpProxy(options),
                getHttpHeadersV2(uri, request, options),
                request,
                SubscriptionCheckoutFormInitialize.class);
    }

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
}
