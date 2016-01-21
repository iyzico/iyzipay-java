package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreatePaymentRequest;

public class PaymentAuth extends Payment {

    public static PaymentAuth create(CreatePaymentRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyzipos/auth/ecom",
                        getHttpHeaders(request, options),
                        request,
                        PaymentAuth.class)
                .getBody();
    }
}
