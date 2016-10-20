package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreatePeccoPaymentRequest;

public class PeccoPayment extends PaymentResource {

    private String token;

    public static PeccoPayment create(CreatePeccoPaymentRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/pecco/auth",
                getHttpHeaders(request, options),
                request,
                PeccoPayment.class);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
