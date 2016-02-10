package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.RetrieveBKMAuthRequest;

public class BKMAuth extends Payment {

    private String token;
    private String callbackUrl;

    public static BKMAuth retrieve(RetrieveBKMAuthRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyzipos/bkm/auth/ecom/detail",
                getHttpHeaders(request, options),
                request,
                BKMAuth.class);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }
}
