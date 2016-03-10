package com.iyzipay.model;

import com.iyzipay.Options;
import com.iyzipay.request.RetrieveBKMAuthRequest;

public class ConnectBKMAuth extends ConnectPayment {

    private String token;
    private String callbackUrl;
    private String paymentStatus;

    public static ConnectBKMAuth retrieve(RetrieveBKMAuthRequest request, Options options) {
        return httpClient.post(options.getBaseUrl() + "/payment/iyziconnect/bkm/auth/detail",
                getHttpHeaders(request, options),
                request,
                ConnectBKMAuth.class);
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