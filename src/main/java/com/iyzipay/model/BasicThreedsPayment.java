package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateThreedsPaymentRequest;

public class BasicThreedsPayment extends BasicPaymentResource {

    public static BasicThreedsPayment create(CreateThreedsPaymentRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/3dsecure/auth/basic",
                getHttpProxy(options),
                getHttpHeaders(request, options),
                request,
                BasicThreedsPayment.class);
    }
}
