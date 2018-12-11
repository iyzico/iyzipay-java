package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.RetrieveBkmRequest;

public class BasicBkm extends BasicPaymentResource {

    private String token;
    private String callbackUrl;
    private String paymentStatus;

    public static BasicBkm retrieve(RetrieveBkmRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/bkm/auth/detail/basic",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                BasicBkm.class);
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

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}