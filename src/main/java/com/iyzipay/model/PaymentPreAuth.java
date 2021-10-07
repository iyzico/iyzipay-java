package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreatePaymentRequest;
import com.iyzipay.request.RetrievePaymentRequest;

public class PaymentPreAuth extends PaymentResource {

    public static PaymentPreAuth create(CreatePaymentRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/preauth",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                PaymentPreAuth.class);
    }

    public static PaymentPreAuth retrieve(RetrievePaymentRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/detail",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                PaymentPreAuth.class);
    }
}
