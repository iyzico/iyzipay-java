package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreatePaymentPostAuthRequest;

public class PaymentPostAuth extends Payment {

    public static PaymentPostAuth create(CreatePaymentPostAuthRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyzipos/postauth",
                getHttpHeaders(request, options),
                request,
                PaymentPostAuth.class);
    }
}
