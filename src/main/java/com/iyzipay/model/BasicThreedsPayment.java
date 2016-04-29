package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateThreedsPaymentRequest;

public class BasicThreedsPayment extends BasicPaymentResource {

    public static BasicThreedsPayment create(CreateThreedsPaymentRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyziconnect/auth3ds",
                getHttpHeaders(request, options),
                request,
                BasicThreedsPayment.class);
    }
}