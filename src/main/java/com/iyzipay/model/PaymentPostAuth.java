package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreatePaymentPostAuthRequest;

public class PaymentPostAuth extends PaymentResource {

    public static PaymentPostAuth create(CreatePaymentPostAuthRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/postauth",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                PaymentPostAuth.class);
    }
}
