package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreateBasicPaymentRequest;

public class BasicPayment extends BasicPaymentResource {

    public static BasicPayment create(CreateBasicPaymentRequest request, Options options) {
        String path = "/payment/auth/basic";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                BasicPayment.class);
    }
}
