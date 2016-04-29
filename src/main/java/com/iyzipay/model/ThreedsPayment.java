package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateThreedsPaymentRequest;
import com.iyzipay.request.RetrievePaymentRequest;

public class ThreedsPayment extends PaymentResource {

    public static ThreedsPayment create(CreateThreedsPaymentRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyzipos/auth3ds/ecom",
                getHttpHeaders(request, options),
                request,
                ThreedsPayment.class);
    }

    public static ThreedsPayment retrieve(RetrievePaymentRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/detail",
                getHttpHeaders(request, options),
                request,
                ThreedsPayment.class);
    }
}
