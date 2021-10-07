package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreatePaymentRequest;
import com.iyzipay.request.RetrievePaymentRequest;

public class Payment extends PaymentResource {

    public static Payment create(CreatePaymentRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/auth",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                Payment.class);
    }

    public static Payment retrieve(RetrievePaymentRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/detail",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                Payment.class);
    }
}
