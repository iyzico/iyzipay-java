package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreatePaymentPostAuthRequest;

public class BasicPaymentPostAuth extends BasicPaymentResource {

    public static BasicPaymentPostAuth create(CreatePaymentPostAuthRequest request, Options options) {
        String path = "/payment/postauth/basic";
        return HttpClient.create().post(options.getBaseUrl() + path,
                getHttpProxy(options),
                getHttpHeadersV2(path, request, options),
                request,
                BasicPaymentPostAuth.class);
    }
}
