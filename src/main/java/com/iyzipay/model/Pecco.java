package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreatePeccoAuthRequest;

public class Pecco extends PaymentResource {

    private String token;

    public static Pecco create(CreatePeccoAuthRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyzipos/pecco/auth",
                getHttpHeaders(request, options),
                request,
                Pecco.class);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
