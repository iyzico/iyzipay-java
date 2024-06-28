package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateThreedsPaymentRequest;

public class BasicThreedsPayment extends BasicPaymentResource {

    public static BasicThreedsPayment create(CreateThreedsPaymentRequest request, Options options) {
        String path = "/payment/3dsecure/auth/basic";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                BasicThreedsPayment.class);
    }
}
