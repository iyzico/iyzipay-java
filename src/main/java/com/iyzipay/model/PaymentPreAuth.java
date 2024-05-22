package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreatePaymentRequest;
import com.iyzipay.request.RetrievePaymentRequest;

public class PaymentPreAuth extends PaymentResource {

    public static PaymentPreAuth create(CreatePaymentRequest request, Options options) {
        String path = "/payment/preauth";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                PaymentPreAuth.class);
    }

    public static PaymentPreAuth retrieve(RetrievePaymentRequest request, Options options) {
        String path = "/payment/detail";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                PaymentPreAuth.class);
    }
}
