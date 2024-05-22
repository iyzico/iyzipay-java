package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreatePaymentPostAuthRequest;

public class PaymentPostAuth extends PaymentResource {

    public static PaymentPostAuth create(CreatePaymentPostAuthRequest request, Options options) {
        String path = "/payment/postauth";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                PaymentPostAuth.class);
    }
}
