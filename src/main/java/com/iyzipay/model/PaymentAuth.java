package com.iyzipay.model;

import com.iyzipay.Options;
import com.iyzipay.request.CreatePaymentRequest;
import com.iyzipay.request.RetrievePaymentRequest;

public class PaymentAuth extends Payment {

    public static PaymentAuth create(CreatePaymentRequest request, Options options) {
        return options.getHttpClient().post(options.getBaseUrl() + "/payment/iyzipos/auth/ecom",
                getHttpHeaders(request, options),
                request,
                PaymentAuth.class);
    }

    public static PaymentAuth retrieve(RetrievePaymentRequest request, Options options) {
        return options.getHttpClient().post(options.getBaseUrl() + "/payment/detail",
                getHttpHeaders(request, options),
                request,
                PaymentAuth.class);
    }
}
